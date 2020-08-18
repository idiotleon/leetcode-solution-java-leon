/**
 * https://leetcode.com/problems/coin-change/
 * 
 * Time Complexity:     O(N * (amount ^ 2))
 * Space Complexity:    O()
 * 
 * References:
 *  https://www.youtube.com/watch?v=uUETHdijzkA
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-322-coin-change/
 */
package com.zea7ot.leetcode.lvl3.lc0322;

import java.util.Arrays;

public class SolutionApproach1DP1Dimen1 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int coin : coins){
            for(int i = amount - coin; i >= 0; --i){
                if(dp[i] != Integer.MAX_VALUE){
                    for(int k = 1; k * coin + i <= amount; ++k){
                        dp[i + k * coin] = Math.min(dp[i + k * coin], dp[i] + k);
                    }
                }
            }
        }
     
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}