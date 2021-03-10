/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://www.youtube.com/watch?v=jNy8yM0NBdw
 *  https://youtu.be/FLbqgyJ-70I?t=1117
 */
package com.an7one.leetcode.lvl4.lc0309;

public class SolutionApproach0DP2Dimen {
    public int maxProfit(int[] prices) {
        // sanity check
        if (prices == null || prices.length == 0)
            return 0;

        final int N = prices.length;
        int[][] dp = new int[N][3];
        // held
        dp[0][0] = -prices[0];
        // sold
        dp[0][1] = 0;
        // cooled down
        dp[0][2] = 0;

        for (int i = 1; i < N; ++i) {
            // held
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            // sold
            dp[i][1] = dp[i - 1][0] + prices[i];
            // cooled down
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return Math.max(dp[N - 1][1], dp[N - 1][2]);
    }
}