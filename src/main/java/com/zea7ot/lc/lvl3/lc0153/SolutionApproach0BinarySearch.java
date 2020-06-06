/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * Time Complexity: O(lg(N))
 * Space Complexity: O(1)
 */
package com.zea7ot.lc.lvl3.lc0153;

public class SolutionApproach0BinarySearch {
    public int findMin(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return -1;
        
        if(nums.length == 1) return nums[0];
        final int L = nums.length;
        int left = 0, right = L - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(mid < L - 1 && nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if(mid > 1 && nums[mid - 1] > nums[mid]) return nums[mid];
            
            if(nums[left] < nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        
        return nums[0];
    }
}