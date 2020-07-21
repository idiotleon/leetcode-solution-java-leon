/**
 * https://leetcode.com/problems/paint-house/
 * 
 * if the options of colors are not limited to 3, but n
 */
package com.zea7ot.lc.lvl3.lc0256.followup;

public class SolutionApproach0DP {
    public int minCost(int[][] costs) {
        // sanity check
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        
        final int M = costs.length, N = costs[0].length;
        int[][] dp = new int[M][N];
        for(int j = 0; j < N; j++) dp[0][j] = costs[0][j];
        
        for(int i = 1; i < M; i++){
            for(int j = 0; j < N; j++){
                dp[i][j] = costs[i][j] + findMinInOneRow(i - 1, j, dp);
            }
        }
        
        return findMinInOneRow(M - 1, -1, dp);
    }
    
    private int findMinInOneRow(int i, int j, int[][] dp){
        int min = Integer.MAX_VALUE;
        for(int k = 0; k < dp[0].length; k++){
            // to skip the same column/color as the previously selected column/color
            if(k == j) continue;
            min = Math.min(min, dp[i][k]);
        }
        
        return min;
    }
}