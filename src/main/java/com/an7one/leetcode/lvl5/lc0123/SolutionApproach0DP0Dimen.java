/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://www.youtube.com/watch?v=gsL3T9bI1RQ
 */
package com.an7one.leetcode.lvl5.lc0123;

public class SolutionApproach0DP0Dimen {
    public int maxProfit(int[] prices) {
        // sanity check
        if (prices == null || prices.length == 0)
            return 0;

        int held1 = -prices[0], held2 = -prices[0];
        int sold1 = 0, sold2 = 0;

        for (int price : prices) {
            final int PREV_HELD1 = held1, PREV_HELD2 = held2;
            final int PREV_SOLD1 = sold1, PREV_SOLD2 = sold2;

            held1 = Math.max(PREV_HELD1, -price);
            sold1 = Math.max(PREV_SOLD1, PREV_HELD1 + price);
            held2 = Math.max(PREV_HELD2, PREV_SOLD1 - price);
            sold2 = Math.max(PREV_SOLD2, PREV_HELD2 + price);
        }

        return sold2;
    }
}