/**
 * https://leetcode.com/problems/search-insert-position/
 */
package com.polyg7ot.lc.lvl2.lc0035;

public class SolutionApproachBinarySearch{
    public int searchInsert(int[] nums, int target) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        int left = 0, right = nums.length;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if(target < nums[mid]) right = mid;
            else left = mid + 1;
        }
        
        return left;
    }
}