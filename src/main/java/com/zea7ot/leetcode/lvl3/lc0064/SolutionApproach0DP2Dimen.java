/**
 * https://leetcode.com/problems/minimum-path-sum/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC) / O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0064;

import java.util.Arrays;

public class SolutionApproach0DP2Dimen {
    public int minPathSum(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        final int NR = grid.length, NC = grid[0].length;

        int[][] dp = new int[NR][NC];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        dp[0][0] = grid[0][0];
        for (int col = 1; col < NC; ++col)
            dp[0][col] = dp[0][col - 1] + grid[0][col];
        for (int row = 1; row < NR; ++row)
            dp[row][0] = dp[row - 1][0] + grid[row][0];

        for (int row = 1; row < NR; ++row) {
            for (int col = 1; col < NC; ++col) {
                dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
            }
        }

        return dp[NR - 1][NC - 1];
    }
}