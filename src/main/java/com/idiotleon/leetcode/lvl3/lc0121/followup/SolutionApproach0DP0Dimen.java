/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *  
 * how about sell short?
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl3.lc0121.followup;

public class SolutionApproach0DP0Dimen {
    public int maxProfit(int[] prices) {
        int maxPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price > maxPrice)
                maxPrice = price;

            int profit = maxPrice - price;
            if (profit > maxProfit)
                maxProfit = profit;
        }

        return maxProfit;
    }
}