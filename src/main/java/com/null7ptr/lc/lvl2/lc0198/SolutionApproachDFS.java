/**
 * https://leetcode.com/problems/house-robber/
 * 
 * Recursion (top - down)
 * https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 */
package com.null7ptr.lc.lvl2.lc0198;

public class SolutionApproachDFS {
    public int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }
    
    private int rob(int[] nums, int i){
        if(i < 0) return 0;
        
        return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    }
}