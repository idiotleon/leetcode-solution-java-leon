/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 
 * Time Complexity:     O(k * N)
 * Space Complexity:    O(k * N)
 * 
 * References:
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54117/Clean-Java-DP-solution-with-comment
 */
package com.zea7ot.lc.lvl4.lc0188;

public class SolutionApproach0DP2Dimen {
    public int maxProfit(int k, int[] prices) {
        final int N = prices.length;
        if (N <= 1)
            return 0;

        if (k >= N / 2) {
            int maxProfit = 0;
            for (int i = 1; i < N; i++) {
                if (prices[i - 1] < prices[i]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        int[][] dp = new int[k + 1][N];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[k][N - 1];
    }
}