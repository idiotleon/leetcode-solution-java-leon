/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)
 */
package com.zea7ot.lc.lvl4.lc0309;

public class SolutionApproach0DP {
    public int maxProfit(int[] prices) {
        int sold = 0, hold = Integer.MIN_VALUE, rest = 0;
        for(int price : prices){
            int prevSold = sold;
            sold = hold + price;
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, prevSold);
        }
        
        return Math.max(sold, rest);
    }
}