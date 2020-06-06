/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * Time Complexity: O(2 * lg(N)) ~ O(lg(N))
 * Space Complexity: O(1)
 * 
 * References:
 *  https://stackoverflow.com/a/44232847/6061609
 */
package com.zea7ot.lc.lvl3.lc0034;

public class SolutionApproach0BinarySearch1 {
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearchLeftmost(nums, target);
        if(start == nums.length || nums[start] != target){
            return new int[]{-1, -1};
        }
        
        return new int[]{start, binarySearchLeftmost(nums, target + 1) - 1};
    }
    
    private int binarySearchLeftmost(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            // this cannot be here
            //if(nums[mid] == target) return mid;
            if(target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        
        return left;
    }
}