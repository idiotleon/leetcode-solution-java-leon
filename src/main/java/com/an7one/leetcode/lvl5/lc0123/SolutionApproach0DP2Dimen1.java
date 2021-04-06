package com.an7one.leetcode.lvl5.lc0123;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * <p>
 * Time Complexity:     O(k * (N ^ 2))
 * Space Complexity:    O(kN)
 * <p>
 * a general approach with at most k transactions
 * <p>
 * References:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/135704/Detail-explanation-of-DP-solution
 */
public class SolutionApproach0DP2Dimen1 {
    public int maxProfit(int[] prices) {
        // sanity check
        if (prices == null || prices.length == 0)
            return 0;

        final int N = prices.length;
        int[][] dp = new int[3][N];
        for (int k = 1; k <= 2; k++) {
            for (int i = 1; i < N; i++) {
                int min = prices[0];
                for (int j = 1; j <= i; j++) {
                    min = Math.min(min, prices[j] - dp[k - 1][j - 1]);
                }
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }

        return dp[2][N - 1];
    }
}