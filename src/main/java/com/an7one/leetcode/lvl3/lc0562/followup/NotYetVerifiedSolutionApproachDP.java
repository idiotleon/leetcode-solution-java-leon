/**
 * https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/
 * 
 * Instead of giving a 2D array with definite dimensions,
 * how about giving a 2D list with rows of possibly different dimensions?
 */
package com.an7one.leetcode.lvl3.lc0562.followup;

import java.util.List;

public class NotYetVerifiedSolutionApproachDP {
    public int longestLine(List<List<Integer>> matrix) {
        // sanity check
        if(matrix == null || matrix.isEmpty()) return 0;
        
        final int NR = matrix.size();

        int len = 0;
        for(List<Integer> row : matrix){
            len = Math.max(len, row.size());
        }
        final int NC = len;
        
        int[][][] dp = new int[NR][NC][4];
        int maxLen = 0;
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < matrix.get(row).size(); col++){
                if(matrix.get(row).get(col) == 1){   // to ignore zeros
                    dp[row][col][0] = (row > 0 && matrix.get(row - 1).get(col) == 1) ? dp[row - 1][col][0] + 1: 1;
                    
                    dp[row][col][1] = (col > 0 && matrix.get(row).get(col - 1) == 1) ? dp[row][col - 1][1] + 1 : 1;
                    
                    dp[row][col][2] = (row > 0 && col > 0 && matrix.get(row - 1).get(col - 1) == 1) ? dp[row - 1][col - 1][2] + 1 : 1;
                    
                    dp[row][col][3] = (row > 0 && col < matrix.get(row).size() - 1 && matrix.get(row - 1).get(col + 1) == 1) ? dp[row - 1][col + 1][3] + 1 : 1;
                }
                
                for(int k = 0; k < 4; k++){
                    maxLen = Math.max(maxLen, dp[row][col][k]);
                }
            }
        }
        
        return maxLen;
    }
}