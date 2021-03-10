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

public class SolutionApproach0DP1 {
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