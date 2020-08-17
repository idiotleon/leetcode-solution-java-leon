/**
 * https://leetcode.com/problems/search-insert-position/
 * 
 * Time Complexity: O(lg(N))
 * Space Complexity: O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0035;

public class SolutionApproachBinarySearch{
    public int searchInsert(int[] nums, int target) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        int left = 0, right = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        }
        
        return left;
    }
}