/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 
 * Time Complexity:     O(k * N)
 * Space Complexity:    O(k * N)
 * 
 * References:
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54117/Clean-Java-DP-solution-with-comment
 */
package com.idiotleon.leetcode.lvl4.lc0188;

public class SolutionApproach0DP2Dimen {
    public int maxProfit(final int K, int[] prices) {
        final int N = prices.length;
        // covered below
        // if(N <= 1) return 0;

        if (K >= N / 2) {
            int maxProfit = 0;
            for (int day = 1; day < N; ++day) {
                if (prices[day - 1] < prices[day]) {
                    maxProfit += prices[day] - prices[day - 1];
                }
            }
            return maxProfit;
        }

        int[][] dp = new int[K + 1][N];
        for (int k = 1; k <= K; ++k) {
            int localMax = dp[k - 1][0] - prices[0];

            for (int day = 1; day < N; ++day) {
                dp[k][day] = Math.max(dp[k][day - 1], localMax + prices[day]);
                localMax = Math.max(localMax, dp[k - 1][day] - prices[day]);
            }
        }

        return dp[K][N - 1];
    }
}