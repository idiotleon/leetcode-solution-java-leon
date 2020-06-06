/**
 * @author: Leon
 * 
 * pseudo code:
 *  binarySearch(nums, lo, hi)
 *      mid = lo + (hi - lo) / 2
 *      if f(mid): binarySearch(nums, lo, mid)
 *      else binarySearch(nums, mid + 1, hi)
 * 
 * Time Complexity:
 *  T(N) = T(N / 2) + O(1) = O(lg(N))
 * 
 * Space Comlexity:
 *  O(lg(N))
 * 
 * 
 * 
 * References:
 *  https://en.wikipedia.org/wiki/Binary_search_algorithm
 *  https://stackoverflow.com/a/30928332/6061609
 *  https://www.youtube.com/watch?v=OQi4n8EKRD8
 *  https://www.youtube.com/watch?v=v57lNF2mb_s
 *  https://www.youtube.com/watch?v=J-IQxfYRTto
 */
package com.zea7ot.algorithm.summary.search.binary_search;

public class BinarySearch {
    /**
     * Search Range: [low, high]
     */
    public int binarySearch(int[] nums, int target){
        // please pay twice attention to the initial condition of hi(ptr)
        int lo = 0, hi = nums.length - 1;
        System.out.println("binarySearch - initial lo: " + lo);
        System.out.println("binarySearch - initial hi: " + hi);
        while(lo <= hi){
            // to floor the mid
            int mid = lo + (hi - lo) / 2;
            System.out.println("binarySearch - mid: " + mid);

            // to check whether the middle element is equal to the target in every iteration
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]) {
                lo = mid + 1;
                System.out.println("binarySearch - lo: " + lo);
            } else {
                hi = mid - 1;
                System.out.println("binarySearch - hi: " + hi);
            }
        }

        /**
         * to return as the unsuccessful search
         * 
         * were the target not in the array,
         * lo(pointer) stops at the himost of target's immediate smaller element,
         *  e.g. 2  0035    https://leetcode.com/problems/search-insert-position/
         * while hi(pointer) stops at one more lo than the lo(pointer)
         */ 
        return -1;
    }

    public int binarySearchWithFlooringMid(int[] nums, int target){
        int lo = 0, hi = nums.length - 1;
        System.out.println("binarySearch - initial lo: " + lo);
        System.out.println("binarySearch - initial hi: " + hi);
        while(lo <= hi){
            // to floor the mid
            int mid = lo + (hi - lo) / 2;
            System.out.println("binarySearch - mid: " + mid);

            // to check whether the middle element is equal to the target in every iteration
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]) {
                lo = mid + 1;
                System.out.println("binarySearch - lo: " + lo);
            } else {
                hi = mid;
                System.out.println("binarySearch - hi: " + hi);
            }
        }

        return -1;
    }



    public int binarySearchWithCeilingMid(int[] nums, int target){
        int lo = 0, hi = nums.length - 1;
        System.out.println("binarySearchWithCeilingMid - initial lo: " + lo);
        System.out.println("binarySearchWithCeilingMid - initial hi: " + hi);
        while(lo <= hi){
            // to ceil the mid
            int mid = lo + (hi - lo + 1) / 2;
            System.out.println("binarySearchWithCeilingMid - mid: " + mid);

            // to check whether the middle element is equal to the target in every iteration
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]) {
                lo = mid;
                System.out.println("binarySearchWithCeilingMid - lo: " + lo);
            } else {
                hi = mid - 1;
                System.out.println("binarySearchWithCeilingMid - hi: " + hi);
            }
        }

        return -1;
    }

    /**
     * function binary_search_alternative(A, n, T) is
     *  L := 0
     *  R := n − 1
     *  while L != R do
     *      m := ceil((L + R) / 2)
     *      if A[m] > T then
     *          R := m - 1
     *      else:
     *          L := m
     *  if A[L] = T then
     *      return L
     *  return unsuccessful
     * 
     * @param nums
     * @param target
     * @return
     */
    public int binarySearchHermann(int[] nums, int target){
        int lo = 0, hi = nums.length - 1;
        while(lo != hi){
            // to ceil the mid
            int mid = lo + (hi - lo) / 2 + 1;

            // no need to check whether the middle element is equal to the target
            
            if(target < nums[mid]) hi = mid - 1;
            else lo = mid;
        }

        // to check whether the lo element is equal to the target
        if(nums[lo] == target) return lo;
        // to return as the unsuccessful search
        return -1;
    }

    /// where duplicates exist

    /*** 
     * search range: [low, high)
     * 
     * if the target is in the array
     *  to return the index of the lomost target
     *  the index of the himost target can be acquired as: 
     *  binarySearchLowest(nums, target + 1) - 1
     *  regardless of the existence of (target + 1) 
     * 
     * if the target is not in the array, 
     *  depending on the relative position of the element:
     * 
     *  if the element is on the latter half of the array, last position inclusive                  eg. [5,7,7,8,8,10,10]
     *  to return the index of the next himost immediate smaller element if there is any,        eg. target = 9, to return 5
     *  or the length of the array                                                                  eg. target = 11, to return 7
     * 
     *  if the element is on the former half of the array, beginning position inclusive             eg. [5,5,5,7,7,8,8,10]
     *  to return the index of the previous himost immediate smaller element if there is any,    eg. target = 6, to return 3
     *  or 0    
     */
    public int binarySearchLowest(int[] nums, int target){
        int lo = 0, hi = nums.length;
        System.out.println("binarySearchLowest - initial lo: " + lo);
        System.out.println("binarySearchLowest - initial hi: " + hi);

        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            System.out.println("binarySearchLowest - mid: " + mid);

            // please pay twice attention to the equality case
            if(target > nums[mid]) {    // search range: [mid + 1, hi)
                lo = mid + 1;
                System.out.println("binarySearchLowest - lo: " + lo);
             } else {   // search range: [lo, mid)
                 hi = mid;
                 System.out.println("binarySearchLowest - hi: " + hi);
             }
        }

        /**
         * to find the smallest element, so that g(m) is true
         * https://youtu.be/v57lNF2mb_s?t=391
         */
        return lo;  
    }

    /**
     * search range: [low, high)
     * 
     * if the target is in the array
     *  to return the index of the hi target
     * 
     * if the target is not in the array, 
     *  depending on the relative position of the element:
     * 
     *  if the element is on the latter half of the array, last position inclusive                          eg. [5,5,8,8,8,8,10,10]
     *  to return the index of the previous (himost - 1) immediate smaller element if there is any,      eg. target = 9, to return 5
     *  or the length of the array                                                                          eg. target = 11, to return 7
     * 
     *  if the element is on the former half of the array, beginning position inclusive                     eg. [5,5,5,7,7,8,8,10]
     *  to return the index of the previous (himost - 1) immediate smaller element if there is any,      eg. target = 6, to return 3
     *  or -1   
     */
    public int binarySearchHighest(int[] nums, int target){
        int lo = 0, hi = nums.length;
        System.out.println("binarySearchHighest - initial lo: " + lo);
        System.out.println("binarySearchHighest - initial hi: " + hi);

        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            System.out.println("binarySearchHighest - mid: " + mid);

            // please pay twice attention to the equality case
            if(target < nums[mid]) {
                hi = mid;
                System.out.println("binarySearchHighest - hi: " + hi);
            } else {
                lo = mid + 1;
                System.out.println("binarySearchHighest - lo: " + lo);
            }
        }

        return hi - 1;
    }

    // yet unrecongized binary searches
    // https://leetcode.com/problems/divide-chocolate/discuss/408503/JavaC%2B%2BPython-Binary-Search
    public int maximizeSweetness(int[] A, int K) {
        int lo = 1, hi = (int)1e9 / (K + 1);
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            int cur = 0, cuts = 0;
            for (int a : A) {
                if ((cur += a) >= mid) {
                    cur = 0;
                    if (++cuts > K) break;
                }
            }
            if (cuts > K)
                lo = mid;
            else
                hi = mid - 1;
        }
        return lo;
    }
}