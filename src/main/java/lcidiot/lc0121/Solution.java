/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
package main.java.lcidiot.lc0121;

class Solution {
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