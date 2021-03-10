/**
 * @author: Leon
 * https://leetcode.com/problems/unique-paths-ii/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 */
package com.an7one.leetcode.lvl2.lc0063;

public class SolutionApproach0DP2Dimen {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // sanity check
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;

        final int NR = obstacleGrid.length, NC = obstacleGrid[0].length;

        int[][] dp = new int[NR][NC];
        dp[0][0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
        for (int col = 1; col < NC; ++col)
            dp[0][col] = (obstacleGrid[0][col] == 1) ? 0 : dp[0][col - 1];
        for (int row = 1; row < NR; ++row)
            dp[row][0] = (obstacleGrid[row][0] == 1) ? 0 : dp[row - 1][0];

        for (int row = 1; row < NR; ++row)
            for (int col = 1; col < NC; ++col) {
                if (obstacleGrid[row][col] == 1)
                    dp[row][col] = 0;
                else
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }

        return dp[NR - 1][NC - 1];
    }
}