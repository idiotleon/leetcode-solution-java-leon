/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)
 *  https://youtu.be/FLbqgyJ-70I?t=1117
 */
package com.idiotleon.leetcode.lvl4.lc0309;

public class SolutionApproach0DP0Dimen1 {
    public int maxProfit(int[] prices) {
        // sanity check
        if (prices == null || prices.length == 0)
            return 0;

        int sold = 0, held = Integer.MIN_VALUE, cooledDown = 0;
        for (int price : prices) {
            final int PREV_SOLD = sold;
            sold = held + price;
            held = Math.max(held, cooledDown - price);
            cooledDown = Math.max(cooledDown, PREV_SOLD);
        }

        return Math.max(sold, cooledDown);
    }
}