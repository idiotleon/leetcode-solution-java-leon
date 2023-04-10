/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://www.youtube.com/watch?v=jNy8yM0NBdw
 *  https://youtu.be/FLbqgyJ-70I?t=1117
 */
package com.idiotleon.leetcode.lvl4.lc0309;

public class SolutionApproach0DP0Dimen {
    public int maxProfit(int[] prices) {
        // sanity check
        if (prices == null || prices.length == 0)
            return 0;

        int held = -prices[0], sold = 0, cooledDown = 0;
        for (int price : prices) {
            final int PREV_HELD = held;
            final int PREV_SOLD = sold;
            final int PREV_COOLED_DOWN = cooledDown;

            sold = PREV_HELD + price;
            held = Math.max(PREV_HELD, PREV_COOLED_DOWN - price);
            cooledDown = Math.max(PREV_SOLD, PREV_COOLED_DOWN);
        }

        return Math.max(sold, cooledDown);
    }
}