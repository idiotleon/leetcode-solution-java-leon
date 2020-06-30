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
        if(m <= 0 || n <= 0) return 0;

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        
        return dp[m - 1][n - 1];
    }
}