/**
 * https://leetcode.com/problems/coin-change/
 * 
 * Time Complexity:     O(`N` * `RANGE`)
 * Space Complexity:    O(`RANGE`)
 * 
 * References:
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-322-coin-change/
 *  https://leetcode.com/problems/coin-change/discuss/77360/C++-O(n*amount)-time-O(amount)-space-DP-solution/81406
 */
package com.idiotleon.leetcode.lvl3.lc0322;

import java.util.Arrays;

public class SolutionApproach0KnapsackComplete {
    public int coinChange(int[] coins, int amount) {
        // not used
        // final int N = coins.length;

        final int RANGE = 1 + amount;
        int[] dp = new int[RANGE];
        Arrays.fill(dp, RANGE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; ++i) {
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[amount] >= amount + 1 ? -1 : dp[amount];
    }
}