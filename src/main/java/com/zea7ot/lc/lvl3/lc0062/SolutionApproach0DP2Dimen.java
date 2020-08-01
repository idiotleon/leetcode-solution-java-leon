/**
 * https://leetcode.com/problems/unique-paths/
 * 
 * Time Complexity:     O(m * n)
 * Space Complexity:    O(m * n)
 */
package com.zea7ot.lc.lvl3.lc0062;

public class SolutionApproach0DP2Dimen {
    public int uniquePaths(int m, int n) {
        // sanity check
        if (m <= 0 || n <= 0)
            return 0;

        int[][] dp = new int[m][n];
        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {
                if (row == 0 || col == 0)
                    dp[row][col] = 1;
                else
                    dp[row][col] = dp[row][col - 1] + dp[row - 1][col];
            }
        }

        return dp[m - 1][n - 1];
    }
}