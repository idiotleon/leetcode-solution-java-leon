/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
package com.polyg7ot.lc.lvl4.lc0188;

/**
 * https://www.youtube.com/watch?v=oDhu5uGq_ic
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/StockBuySellKTransactions.java
 * 
 * Given stockc prices for certain days and at most k transactions how to buy and sell
 * to maximize profit.
 *
 * Time complexity - O(number of transactions * number of days)
 * Space complexity - O(number of transcations * number of days)
 *
 * https://leetcode.com/discuss/15153/a-clean-dp-solution-which-generalizes-to-k-transactions
 */
public class SolutionApproachDP{
    public int maxProfit(int k, int[] prices) {
        // sanity check
        if(k == 0 || prices.length == 0) return 0;
        
        if(k >= prices.length) 
            return allTimeProfit(prices);
        
        int[] dp = new int[prices.length];
        int[] prev = new int[prices.length];
        for(int i = 1; i <= k; i++){
            int maxDiff = -prices[0];
            for(int j = 1; j < prices.length; j++){
                dp[j] = Math.max(dp[j - 1], maxDiff + prices[j]);
                maxDiff = Math.max(maxDiff, prev[j] - prices[j]);
            }
            
            for(int j = 1; j < prices.length; j++){
                prev[j] = dp[j];
            }
        }
        
        return dp[dp.length - 1];
    }
    
    private int allTimeProfit(int[] prices){
        int profit = 0, localMin = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i - 1] >= prices[i]){
                localMin = prices[i];
            }else{
                profit += prices[i] - localMin;
                localMin = prices[i];
            }
        }
        
        return profit;
    }
}