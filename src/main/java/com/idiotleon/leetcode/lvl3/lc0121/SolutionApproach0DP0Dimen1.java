/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl3.lc0121;

public class SolutionApproach0DP0Dimen1 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);

            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }
}