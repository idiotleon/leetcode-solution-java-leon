/**
 * https://leetcode.com/problems/find-peak-element/
 * 
 * Time Complexity: O(lg(N))
 * Space Complexity: O(lg(N))
 */
package com.polyg7ot.lc.lvl3.lc0162;

public class SolutionApproach0Recursion {
    public int findPeakElement(int[] nums) {
        // sanity check
        if(nums == null || nums.length < 2) return 0;
        
        return helper(nums, 0, nums.length - 1);
    }
    
    private int helper(int[] nums, int low, int high){
        if(low == high) return low;
        else{
            int mid1 = low + (high - low) / 2;
            int mid2 = mid1 + 1;
            if(nums[mid1] > nums[mid2]){
                return helper(nums, low, mid1);
            }else{
                return helper(nums, mid2, high);
            }
        }
    }
}