/**
 * https://leetcode.com/problems/two-city-scheduling/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N ^ 2)
 * 
 * dp[i][j] represents the cost where, 
 * among the first (i + j) people, 
 * i people are assigned to city A,
 * and j people are assigned to city B.
 *  Please be noted that "i" and "j" are actual numbers, NOT sequence.
 * 
 * References:
 *  https://leetcode.com/problems/two-city-scheduling/discuss/278731/Java-DP-Easy-to-Understand
 */
package com.an7one.leetcode.lvl2.lc1029;

public class SolutionApproach0DP2Dimen {
    public int twoCitySchedCost(int[][] costs) {
        // sanity check
        if (costs == null || costs.length == 0)
            return 0;

        final int N = costs.length / 2;
        int[][] dp = new int[N + 1][N + 1];
        for (int row = 1; row <= N; ++row) {
            dp[row][0] = dp[row - 1][0] + costs[row - 1][0];
        }
        for (int col = 1; col <= N; ++col) {
            dp[0][col] = dp[0][col - 1] + costs[col - 1][1];
        }

        for (int row = 1; row <= N; ++row) {
            for (int col = 1; col <= N; ++col) {
                dp[row][col] = Math.min(dp[row - 1][col] + costs[row + col - 1][0], // to assign one more to city A
                        dp[row][col - 1] + costs[row + col - 1][1]); // to assign one more to city B
            }
        }

        return dp[N][N];
    }
}