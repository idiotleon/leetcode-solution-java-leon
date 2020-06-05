/**
 * https://leetcode.com/problems/coin-change/
 * 
 * Time Complexity:     O(N ^ 2), where N ~ amount
 * Space Complexity:    O(N), where N ~ amount
 */
package com.polyg7ot.lc.lvl3.lc0322;

import java.util.Arrays;

public class SolutionApproach0DP1Dimen2 {
    public int coinChange(int[] coins, int amount) {
        // sanity check
        if(coins == null || coins.length == 0 || amount <= 0) return 0;
        
        final int L = coins.length;
        
        // the index of int[] dp means the amount. E.g. index = 7 means amount = 7
        // the actual value of int[] dp means the minimum steps to reach that certain amount/index
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for(int i = 0; i <= amount; i++){
            if(dp[i] == -1) continue;   // this means this amount/index cannot be constructed by any chance
            for(int j = 0; j < L; j++){
                // this means the current construct is too large than then amount/index targeted at, 
                // which is out of our interests
                // to take care of stackoverflow of int(type)
                if((long)i + (long)coins[j] > (long)(amount)) continue;
                
                if(dp[i + coins[j]] == -1){ // this meams this amount/index has not been construcuted before
                    // to intialize it once it is visited for the very 1st time
                    // plus one here means: need one more coin
                    dp[i + coins[j]] = dp[i] + 1;
                }else{  // this means this amount/index has been constructed before
                    // to take the minimum step(s)
                    dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1); 
                }
            }
        }
        
        return dp[amount];
    }
}