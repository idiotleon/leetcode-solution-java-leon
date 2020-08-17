/**
 * @author: Leon
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * Time Complexity:     O(2 * lg(N)) ~ O(lg(N))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://en.wikipedia.org/wiki/Binary_search_algorithm
 */
package com.zea7ot.leetcode.lvl3.lc0034;

public class SolutionApproach0BinarySearch {
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearchLeftmost(nums, target);
        int end = binarySearchRightmost(nums, target);
        if(start > end) return new int[]{-1, -1};
        
        return new int[]{start, end};
    }
    
    /**
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
     *  or 0                                                                                        eg. target = 4, to return 0
     * 
     * @param nums      the array for search
     * @param target    the target to search, which is NOT guaranteed to be in the array
     * @return          the index of the leftmost target, were the target in the array, 
     *                  or were the target not in the array, see the above description
     */
    private int binarySearchLeftmost(int[] nums, int target){
        final int N = nums.length;
        int lo = 0, hi = N;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            
            if(target > nums[mid]) lo = mid + 1;
            // please pay attention to the equality condition:
            // once the target has been found,
            // still to find the left most one,
            // by discarding the right part
            else hi = mid;
        }
        
        return lo;
    }
    
    /**
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
     *  or -1                                                                                               eg. target = 4, to return 0
     * 
     * @param nums      the array for search
     * @param target    the target to search, which is NOT guaranteed to be in the array
     * @return          the index of the rightmost target, were the target in the array, 
     *                  or were the target not in the array, see the above description
     */ 
    private int binarySearchRightmost(int[] nums, int target){
        final int N = nums.length;
        int lo = 0, hi = N;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            
            if(target < nums[mid]) hi = mid;
            // please pay attention to the equality condition:
            // once the target has been found,
            // still to find the right most one,
            // by discarding the left part
            else lo = mid + 1;
        }
        
        return hi - 1;
    }
}