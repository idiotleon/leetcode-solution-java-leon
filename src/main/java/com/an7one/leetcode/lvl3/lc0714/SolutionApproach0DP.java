/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://www.youtube.com/watch?v=CBvPujbmWhU
 */
package com.an7one.leetcode.lvl3.lc0714;

public class SolutionApproach0DP {
    public int maxProfit(int[] prices, int fee) {
        // sanity check
        if (prices == null || prices.length == 0)
            return 0;

        int held = -prices[0], sold = 0;

        for (int price : prices) {
            final int PREV_HELD = held;
            final int PREV_SOLD = sold;
            held = Math.max(PREV_HELD, PREV_SOLD - price);
            sold = Math.max(PREV_SOLD, PREV_HELD + price - fee);
        }

        return sold;
    }
}