/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * Time complexity:     O(number of transactions * number of days)
 * Space complexity:    O(number of transcations * number of days)
 *
 * 
 * References:
 *  https://leetcode.com/discuss/15153/a-clean-dp-solution-which-generalizes-to-k-transactions
 *  https://www.youtube.com/watch?v=oDhu5uGq_ic
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/StockBuySellKTransactions.java
 */
package com.zea7ot.leetcode.lvl4.lc0188;

public class SolutionApproach0DP1Dimen {
    public int maxProfit(int k, int[] prices) {
        // sanity check
        if (k == 0 || prices.length == 0)
            return 0;

        final int N = prices.length;

        if (k >= N)
            return allTimeProfit(prices);

        int[] dp = new int[N];
        int[] prev = new int[N];
        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < N; j++) {
                dp[j] = Math.max(dp[j - 1], maxDiff + prices[j]);
                maxDiff = Math.max(maxDiff, prev[j] - prices[j]);
            }

            for (int j = 1; j < N; j++) {
                prev[j] = dp[j];
            }
        }

        return dp[N - 1];
    }

    private int allTimeProfit(int[] prices) {
        final int N = prices.length;
        int profit = 0, localMin = prices[0];
        for (int i = 1; i < N; i++) {
            if (prices[i - 1] >= prices[i]) {
                localMin = prices[i];
            } else {
                profit += prices[i] - localMin;
                localMin = prices[i];
            }
        }

        return profit;
    }
}