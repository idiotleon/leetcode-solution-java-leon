/**
 * https://leetcode.com/problems/unique-paths-ii/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * This is a typical 2D DP problem, we can store value in 2D DP array, 
 * but since we only need to use value at dp[i - 1][j] and dp[i][j - 1] to update dp[i][j], 
 * we don't need to store the whole 2D table, but instead store value in an 1D array, 
 * and update data by using dp[j] = dp[j] + dp[j - 1], 
 * where here dp[j] corresponding to the dp[i - 1][j],
 * and dp[j - 1] corresponding to the dp[i][j - 1] in the 2D array
 * 
 * 
 * References:
 *  https://leetcode.com/problems/unique-paths-ii/discuss/23250/Short-JAVA-solution
 */
package com.an7one.leetcode.lvl2.lc0063;

public class SolutionApproach0DP1Dimen {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // sanity check
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;

        final int NC = obstacleGrid[0].length;
        int[] dp = new int[NC];
        dp[0] = 1;

        for (int[] row : obstacleGrid) {
            for (int j = 0; j < NC; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }

        return dp[NC - 1];
    }
}