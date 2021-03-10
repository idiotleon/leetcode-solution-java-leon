/**
 * https://leetcode.com/problems/minimum-path-sum/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NC)
 */
package com.an7one.leetcode.lvl2.lc0064;

import java.util.Arrays;

public class SolutionApproach0DP1Dimen {
    public int minPathSum(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0)
            return 0;

        // not used
        // final int NR = grid.length;
        final int NC = grid[0].length;
        int[] dp = new int[NC];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int[] row : grid) {
            for (int col = 0; col < NC; ++col) {
                if (col == 0)
                    dp[col] += row[col];
                else
                    dp[col] = row[col] + Math.min(dp[col - 1], dp[col]);
            }
        }

        return dp[NC - 1];
    }
}