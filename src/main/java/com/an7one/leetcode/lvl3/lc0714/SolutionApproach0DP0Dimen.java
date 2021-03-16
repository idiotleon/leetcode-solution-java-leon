package com.an7one.leetcode.lvl3.lc0714;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * <p>
 * References:
 * https://www.youtube.com/watch?v=CBvPujbmWhU
 */
public class SolutionApproach0DP0Dimen {
    public int maxProfit(int[] prices, int fee) {
        // sanity check
        if (prices == null || prices.length == 0)
            return 0;

        int held = -prices[0], sold = 0;

        for (int price : prices) {
            final int prevHeld = held;
            final int prevSold = sold;
            held = Math.max(prevHeld, prevSold - price);
            sold = Math.max(prevSold, prevHeld + price - fee);
        }

        return sold;
    }
}