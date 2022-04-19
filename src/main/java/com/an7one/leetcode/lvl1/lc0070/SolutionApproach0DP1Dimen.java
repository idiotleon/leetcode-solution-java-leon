package com.an7one.leetcode.lvl1.lc0070;

import com.an7one.util.Constant;

/**
 * @author: Leon
 * https://leetcode.com/problems/climbing-stairs/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP1Dimen {
    public int climbStairs(int n) {
        // sanity check
        if(n == 0) return 1;

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
}