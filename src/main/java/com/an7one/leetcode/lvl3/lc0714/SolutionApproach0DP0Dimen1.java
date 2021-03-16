package com.an7one.leetcode.lvl3.lc0714;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * <p>
 * References:
 * https://www.youtube.com/watch?v=CBvPujbmWhU
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP0Dimen1 {
    public int maxProfit(int[] prices, int fee) {
        // sanity check
        if (prices == null || prices.length == 0)
            return 0;

        int held = Integer.MIN_VALUE, sold = 0;

        for (int price : prices) {
            held = Math.max(held, sold - price);
            sold = Math.max(sold, held + price - fee);
        }

        return sold;
    }
}