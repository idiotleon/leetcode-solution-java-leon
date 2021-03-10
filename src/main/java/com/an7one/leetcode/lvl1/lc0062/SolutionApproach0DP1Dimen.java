/**
 * https://leetcode.com/problems/unique-paths/
 * 
 * Time Complexity:     O(m * n)
 * Space Complexity:    O(n)
 */
package com.an7one.leetcode.lvl1.lc0062;

import java.util.Arrays;

public class SolutionApproach0DP1Dimen {
    public int uniquePaths(int m, int n) {
        // sanity check
        if(m <= 0 || n <= 0)
            return 0;
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int row = 0; row < m; ++row)
            for(int col = 0; col < n; ++col){
                if(row == 0 || col == 0) dp[col] = 1;
                else dp[col] += dp[col - 1];
            }
        
        return dp[n - 1];
    }
}