/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://www.youtube.com/watch?v=CBvPujbmWhU
 */
package com.zea7ot.leetcode.lvl3.lc0714;

public class SolutionApproach0DP1 {
    public int maxProfit(int[] prices, int fee) {
        // sanity check
        if (prices == null || prices.length == 0)
            return 0;

        int held = -prices[0], sold = 0;

        for (int price : prices) {
            int prevHold = held, prevSold = sold;
            held = Math.max(prevHold, prevSold - price);
            sold = Math.max(prevSold, prevHold + price - fee);
        }

        return sold;
    }
}