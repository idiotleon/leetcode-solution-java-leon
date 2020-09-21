/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(4 * N) ~ O(N)
 * 
 * References:
 *  https://youtu.be/FLbqgyJ-70I?t=920
 */
package com.zea7ot.leetcode.lvl5.lc0123;

public class SolutionApproach0DP2Dimen {
    public int maxProfit(int[] prices) {
        // sanity check
        if (prices == null || prices.length == 0)
            return 0;

        final int N = prices.length;
        int[][] dp = new int[N][4];
        // held1
        dp[0][0] = -prices[0];
        // sold1
        dp[0][1] = 0;
        // held2
        dp[0][2] = -prices[0];
        // sold2
        dp[0][3] = 0;

        for (int i = 1; i < N; ++i) {
            // held1
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // sold1
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            // held2
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            // sold2
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }

        // this is actually `dp[i][3]`
        int max = 0;
        for (int profit : dp[N - 1]) {
            max = Math.max(max, profit);
        }

        return max;
    }
}
