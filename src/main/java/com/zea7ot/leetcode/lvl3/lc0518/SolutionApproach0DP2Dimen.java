/**
 * https://leetcode.com/problems/coin-change-2/
 * 
 * Time Complexity:     O(N * amount)
 * Space Complexity:    O(N * amount)
 * 
 * References:
 *  https://leetcode.com/problems/coin-change-2/discuss/99212/Knapsack-problem-Java-solution-with-thinking-process-O(nm)-Time-and-O(m)-Space
 */
package com.zea7ot.leetcode.lvl3.lc0518;

public class SolutionApproach0DP2Dimen {
    public int change(int amount, int[] coins) {
        final int N = coins.length;
        int[][] dp = new int[N + 1][amount + 1];
        dp[0][0] = 1;
        
        for(int i = 1; i <= N; i++){
            dp[i][0] = 1;
            for(int j = 1; j <= amount; j++){
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        
        return dp[N][amount];
    }
}