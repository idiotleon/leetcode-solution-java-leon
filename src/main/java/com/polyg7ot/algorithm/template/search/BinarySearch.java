/**
 * @author: Leon
 * 
 * References:
 *  https://en.wikipedia.org/wiki/Binary_search_algorithm
 *  https://stackoverflow.com/a/30928332/6061609
 */
package com.polyg7ot.algorithm.template.search;

public class BinarySearch {
    /**
     * Search Range: [low, high]
     */
    public int binarySearch(int[] nums, int target){
        // please pay twice attention to the initial condition of right(ptr)
        int left = 0, right = nums.length - 1;
        System.out.println("binarySearch - initial left: " + left);
        System.out.println("binarySearch - initial right: " + right);
        while(left <= right){
            // to floor the mid
            int mid = left + (right - left) / 2;
            System.out.println("binarySearch - mid: " + mid);

            // to check whether the middle element is equal to the target in every iteration
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]) {
                left = mid + 1;
                System.out.println("binarySearch - left: " + left);
            } else {
                right = mid - 1;
                System.out.println("binarySearch - right: " + right);
            }
        }

        /**
         * to return as the unsuccessful search
         * 
         * were the target not in the array,
         * left(pointer) stops at the rightmost of target's immediate smaller element,
         *  e.g. 2  0035    https://leetcode.com/problems/search-insert-position/
         * while right(pointer) stops at one more left than the left(pointer)
         */ 
        return -1;
    }

    public int binarySearchWithFlooringMid(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        System.out.println("binarySearch - initial left: " + left);
        System.out.println("binarySearch - initial right: " + right);
        while(left <= right){
            // to floor the mid
            int mid = left + (right - left) / 2;
            System.out.println("binarySearch - mid: " + mid);

            // to check whether the middle element is equal to the target in every iteration
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]) {
                left = mid + 1;
                System.out.println("binarySearch - left: " + left);
            } else {
                right = mid;
                System.out.println("binarySearch - right: " + right);
            }
        }

        return -1;
    }

    public int binarySearchWithCeilingMid(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        System.out.println("binarySearchWithCeilingMid - initial left: " + left);
        System.out.println("binarySearchWithCeilingMid - initial right: " + right);
        while(left <= right){
            // to ceil the mid
            int mid = left + (right - left + 1) / 2;
            System.out.println("binarySearchWithCeilingMid - mid: " + mid);

            // to check whether the middle element is equal to the target in every iteration
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]) {
                left = mid;
                System.out.println("binarySearchWithCeilingMid - left: " + left);
            } else {
                right = mid - 1;
                System.out.println("binarySearchWithCeilingMid - right: " + right);
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
        int left = 0, right = nums.length - 1;
        while(left != right){
            // to ceil the mid
            int mid = left + (right - left) / 2 + 1;

            // no need to check whether the middle element is equal to the target
            
            if(target < nums[mid]) right = mid - 1;
            else left = mid;
        }

        // to check whether the left element is equal to the target
        if(nums[left] == target) return left;
        // to return as the unsuccessful search
        return -1;
    }

    /// where duplicates exist

    /*** 
     * search range: [low, high)
     * 
     * if the target is in the array
     *  to return the index of the leftmost target
     *  the index of the rightmost target can be acquired as: 
     *  binarySearchLeftmost(nums, target + 1) - 1
     *  regardless of the existence of (target + 1) 
     * 
     * if the target is not in the array, 
     *  depending on the relative position of the element:
     * 
     *  if the element is on the latter half of the array, last position inclusive                  eg. [5,7,7,8,8,10,10]
     *  to return the index of the next rightmost immediate smaller element if there is any,        eg. target = 9, to return 5
     *  or the length of the array                                                                  eg. target = 11, to return 7
     * 
     *  if the element is on the former half of the array, beginning position inclusive             eg. [5,5,5,7,7,8,8,10]
     *  to return the index of the previous rightmost immediate smaller element if there is any,    eg. target = 6, to return 3
     *  or 0    
     */
    public int binarySearchLeftmost(int[] nums, int target){
        int left = 0, right = nums.length;
        System.out.println("binarySearchLeftmost - initial left: " + left);
        System.out.println("binarySearchLeftmost - initial right: " + right);

        while(left < right){
            int mid = left + (right - left) / 2;
            System.out.println("binarySearchLeftmost - mid: " + mid);

            // please pay twice attention to the equality case
            if(target > nums[mid]) {
                left = mid + 1;
                System.out.println("binarySearchLeftmost - left: " + left);
             } else {
                 right = mid;
                 System.out.println("binarySearchLeftmost - right: " + right);
             }
        }

        return left;
    }

    /**
     * search range: [low, high)
     * 
     * if the target is in the array
     *  to return the index of the right target
     * 
     * if the target is not in the array, 
     *  depending on the relative position of the element:
     * 
     *  if the element is on the latter half of the array, last position inclusive                          eg. [5,5,8,8,8,8,10,10]
     *  to return the index of the previous (rightmost - 1) immediate smaller element if there is any,      eg. target = 9, to return 5
     *  or the length of the array                                                                          eg. target = 11, to return 7
     * 
     *  if the element is on the former half of the array, beginning position inclusive                     eg. [5,5,5,7,7,8,8,10]
     *  to return the index of the previous (rightmost - 1) immediate smaller element if there is any,      eg. target = 6, to return 3
     *  or -1   
     */
    public int binarySearchRightmost(int[] nums, int target){
        int left = 0, right = nums.length;
        System.out.println("binarySearchRightmost - initial left: " + left);
        System.out.println("binarySearchRightmost - initial right: " + right);

        while(left < right){
            int mid = left + (right - left) / 2;
            System.out.println("binarySearchRightmost - mid: " + mid);

            // please pay twice attention to the equality case
            if(target < nums[mid]) {
                right = mid;
                System.out.println("binarySearchRightmost - right: " + right);
            } else {
                left = mid + 1;
                System.out.println("binarySearchRightmost - left: " + left);
            }
        }

        return right - 1;
    }

    // yet unrecongized binary searches
    // https://leetcode.com/problems/divide-chocolate/discuss/408503/JavaC%2B%2BPython-Binary-Search
    public int maximizeSweetness(int[] A, int K) {
        int left = 1, right = (int)1e9 / (K + 1);
        while (left < right) {
            int mid = (left + right + 1) / 2;
            int cur = 0, cuts = 0;
            for (int a : A) {
                if ((cur += a) >= mid) {
                    cur = 0;
                    if (++cuts > K) break;
                }
            }
            if (cuts > K)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }
}