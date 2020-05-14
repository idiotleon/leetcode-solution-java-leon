/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 
 * Time Complexity: O(lg(N))
 *  in the worst case: O(N)
 *  e.g.: [1,1,1,1,1,1,5], target = 5
 * Space Complexity: O(1)
 */
package com.polyg7ot.lc.lvl4.lc0081;

public class SolutionApproach0BinarySearch1 {
    public boolean search(int[] nums, int target) {
        // sanity check
        if(nums == null || nums.length == 0) return false;
        
        int left = 0, right = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target) return true;
            
            if(nums[mid] == nums[left]) left++;
            else if(nums[mid] > nums[left]){
                if(nums[mid] > target && nums[left] <= target){
                    right = mid;
                }else left = mid + 1;
            }else{
                if(nums[mid] < target && nums[right] >= target){
                    left = mid + 1;
                }else right = mid;
            }
        }
        
        return false;
    }
}