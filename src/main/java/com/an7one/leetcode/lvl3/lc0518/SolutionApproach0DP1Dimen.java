/**
 * https://leetcode.com/problems/coin-change-2/
 * 
 * Time Complexity:     O(N * amount)
 * Space Complexity:    O(amount)
 * 
 * space can be compressed,
 * since dp[i][j] only depends on dp[i - 1][j] and dp[i][j - coins[i]]
 * 
 * References:
 *  https://leetcode.com/problems/coin-change-2/discuss/99212/Knapsack-problem-Java-solution-with-thinking-process-O(nm)-Time-and-O(m)-Space
 * 
 * Almost the same problem:
 *  https://leetcode.com/problems/combination-sum-iv/discuss/111860/Coin-change-AND-this-problem
 */
package com.an7one.leetcode.lvl3.lc0518;

public class SolutionApproach0DP1Dimen {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}