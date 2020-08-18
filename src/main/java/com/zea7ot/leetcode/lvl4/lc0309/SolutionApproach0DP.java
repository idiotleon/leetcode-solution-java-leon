/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)
 */
package com.zea7ot.leetcode.lvl4.lc0309;

public class SolutionApproach0DP {
    public int maxProfit(int[] prices) {
        // sanity check
        if (prices == null || prices.length == 0)
            return 0;

        int sold = 0, held = Integer.MIN_VALUE, cooledDown = 0;
        for (int price : prices) {
            int prevSold = sold;
            sold = held + price;
            held = Math.max(held, cooledDown - price);
            cooledDown = Math.max(cooledDown, prevSold);
        }

        return Math.max(sold, cooledDown);
    }
}