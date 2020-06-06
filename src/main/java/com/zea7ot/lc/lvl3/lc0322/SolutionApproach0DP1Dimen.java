/**
 * https://leetcode.com/problems/coin-change/
 * 
 * Time Complexity:     O(N * amount)
 * Space Complexity:    O(amount)
 * 
 * References:
 *  https://leetcode.com/problems/coin-change/
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-322-coin-change/
 */
package com.zea7ot.lc.lvl3.lc0322;

import java.util.Arrays;

public class SolutionApproach0DP1Dimen {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        return dp[amount] >= amount + 1 ? -1 : dp[amount];
    }
}