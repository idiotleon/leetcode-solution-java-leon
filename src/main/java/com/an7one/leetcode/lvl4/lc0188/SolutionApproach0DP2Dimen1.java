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
 * MLEed
 * 
 * References:
 *  https://www.youtube.com/watch?v=oDhu5uGq_ic
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/StockBuySellKTransactions.java
 */
package com.an7one.leetcode.lvl4.lc0188;

public class SolutionApproach0DP2Dimen1 {
    public int maxProfit(final int K, int[] prices) {
        final int N = prices.length;
        // sanity check
        if (K == 0 || N == 0)
            return 0;

        int[][] dp = new int[K + 1][N];

        for (int k = 1; k <= K; ++k) {
            int localMax = -prices[0];

            for (int day = 1; day < N; ++day) {
                dp[k][day] = Math.max(dp[k][day - 1], prices[day] + localMax);
                localMax = Math.max(localMax, dp[k - 1][day] - prices[day]);
            }
        }

        return dp[K][N - 1];
    }
}