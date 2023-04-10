/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl3.lc0121;

public class SolutionApproach0DP0Dimen {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice)
                minPrice = price;

            int profit = price - minPrice;
            if (profit > maxProfit)
                maxProfit = profit;
        }

        return maxProfit;
    }
}