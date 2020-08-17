/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * to apply the transaction fee when one buying the stock
 * 
 * References:
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108871/2-solutions-2-states-DP-solutions-clear-explanation!
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
 */
package com.zea7ot.leetcode.lvl3.lc0714;

public class SolutionApproach0DP4 {
    public int maxProfit(int[] prices, int fee) {
        // sanity check
        if (prices == null || prices.length <= 1)
            return 0;
            
        final int N = prices.length;
        int[] buy = new int[N];
        buy[0] = -prices[0] - fee;
        int[] sell = new int[N];

        for (int i = 1; i < N; ++i) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i] - fee);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return sell[N - 1];
    }
}