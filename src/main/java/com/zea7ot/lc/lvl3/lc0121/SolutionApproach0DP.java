/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl3.lc0121;

public class SolutionApproach0DP {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        
        for(int price : prices){
            if(price < minPrice) 
                minPrice = price;
            
            if(price - minPrice > maxProfit) 
                maxProfit = price - minPrice;
        }
        
        return maxProfit;
    }
}