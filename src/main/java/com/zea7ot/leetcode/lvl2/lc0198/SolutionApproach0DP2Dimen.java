/**
 * https://leetcode.com/problems/house-robber/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(2 * N) ~ O(N)
 * 
 * References:
 *  https://youtu.be/FLbqgyJ-70I?t=673
 */
package com.zea7ot.leetcode.lvl2.lc0198;

public class SolutionApproach0DP2Dimen {
    public int rob(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        // `dp[i][0]`: inclusive
        // `dp[i][1]`: exclusive
        int[][] dp = new int[N][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;

        for (int i = 1; i < N; ++i) {
            // inclusive
            dp[i][0] = dp[i - 1][1] + nums[i];
            // exclusive
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.max(dp[N - 1][0], dp[N - 1][1]);
    }
}
