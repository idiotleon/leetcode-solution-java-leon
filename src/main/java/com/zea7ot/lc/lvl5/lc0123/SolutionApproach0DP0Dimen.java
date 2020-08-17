/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://www.youtube.com/watch?v=gsL3T9bI1RQ
 */
package com.zea7ot.lc.lvl5.lc0123;

public class SolutionApproach0DP0Dimen {
    public int maxProfit(int[] prices) {
        // sanity check
        if (prices == null || prices.length == 0)
            return 0;

        int held1 = -prices[0], held2 = -prices[0];
        int sold1 = 0, sold2 = 0;

        for (int price : prices) {
            int prevHeld1 = held1, prevHeld2 = held2;
            int prevSold1 = sold1, prevSold2 = sold2;

            held1 = Math.max(prevHeld1, -price);
            sold1 = Math.max(prevSold1, prevHeld1 + price);
            held2 = Math.max(prevHeld2, prevSold1 - price);
            sold2 = Math.max(prevSold2, prevHeld2 + price);
        }

        return sold2;
    }
}