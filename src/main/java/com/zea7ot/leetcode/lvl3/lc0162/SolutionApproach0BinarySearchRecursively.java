/**
 * https://leetcode.com/problems/find-peak-element/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(lg(N))
 */
package com.zea7ot.leetcode.lvl3.lc0162;

public class SolutionApproach0BinarySearchRecursively {
    public int findPeakElement(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        return dfs(nums, 0, nums.length - 1);
    }
    
    private int dfs(int[] nums, int lo, int hi){
        if(lo == hi) return lo;
        
        int mid = lo + (hi - lo) / 2;
        if(nums[mid] > nums[mid + 1]) return dfs(nums, lo, mid);
        else return dfs(nums, mid + 1, hi);
    }
}