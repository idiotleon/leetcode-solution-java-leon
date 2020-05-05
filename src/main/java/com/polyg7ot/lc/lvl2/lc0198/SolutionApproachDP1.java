/**
 * https://leetcode.com/problems/house-robber/
 * 
 * Iterative + memo (bottom-up)
 * https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 */
package com.polyg7ot.lc.lvl2.lc0198;

public class SolutionApproachDP1 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int val = nums[i];
            memo[i + 1] = Math.max(memo[i], memo[i - 1] + val);
        }
        
        return memo[nums.length];
    }
}