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
package com.an7one.leetcode.lvl3.lc0322;

import java.util.Arrays;

public class SolutionApproach0KnapsackComplete1 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}