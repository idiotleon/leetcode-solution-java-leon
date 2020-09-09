/**
 * https://leetcode.com/problems/paint-house/
 * if the options of colors are not limited to 3, but rather n
 * 
 * Time Complexity:     O(NR * (NC ^ 2))
 * Space Complexity:    O(NR * NC)
 */
package com.zea7ot.leetcode.lvl3.lc0256.followup;

public class SolutionApproach0DP2Dimen {
    public int minCost(int[][] costs) {
        // sanity check
        if (costs == null || costs.length == 0 || costs[0].length == 0)
            return 0;

        final int NR = costs.length, NC = costs[0].length;
        int[][] dp = new int[NR][NC];
        for (int col = 0; col < NC; ++col)
            dp[0][col] = costs[0][col];

        for (int row = 1; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                dp[row][col] = costs[row][col] + findMinInOneRow(row - 1, col, dp);
            }
        }

        return findMinInOneRow(NR - 1, -1, dp);
    }

    private int findMinInOneRow(int i, int j, int[][] dp) {
        final int NC = dp[0].length;
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < NC; ++k) {
            // to skip the same column/color as the previously selected column/color
            if (k == j)
                continue;
            min = Math.min(min, dp[i][k]);
        }

        return min;
    }
}