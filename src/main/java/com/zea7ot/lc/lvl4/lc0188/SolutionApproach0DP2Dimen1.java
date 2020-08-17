/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 
 * Formula is
 * T[i][j] = max(T[i][j-1], prices[j] + maxDiff)
 * maxDiff = max(maxDiff, T[i-1][j] - prices[j])
 * 
 * This is faster method which does optimization on slower method
 * Time complexity here is O(K * number of days)
 * 
 * 
 * References:
 *  https://www.youtube.com/watch?v=oDhu5uGq_ic
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/StockBuySellKTransactions.java
 */
package com.zea7ot.lc.lvl4.lc0188;

public class SolutionApproach0DP2Dimen1 {
    public int maxProfit(int k, int[] prices) {
        // sanity check
        if (k == 0 || prices.length == 0)
            return 0;

        int[][] dp = new int[k + 1][prices.length];

        for (int i = 1; i < dp.length; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[k][prices.length - 1];
    }
}