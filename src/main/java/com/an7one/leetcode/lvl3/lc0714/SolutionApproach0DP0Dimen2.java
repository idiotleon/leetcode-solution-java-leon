package com.an7one.leetcode.lvl3.lc0714;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * <p>
 * References:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108868/Java-simple-DP-solutions.-O(n)/110982
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108868/Java-simple-DP-solutions.-O(n)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP0Dimen2 {
    public int maxProfit(int[] prices, int fee) {
        // sanity check
        if (prices == null || prices.length == 0)
            return 0;

        final int N = prices.length;
        int buy = -prices[0], sell = 0;
        for (int i = 1; i < N; ++i) {
            final int tempBuy = buy;
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, tempBuy + prices[i] - fee);
        }

        return Math.max(buy, sell);
    }
}