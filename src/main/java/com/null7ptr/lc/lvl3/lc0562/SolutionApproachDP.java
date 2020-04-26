/**
 * https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/
 * 
 * Time Complexity: O(M * N * 4) ~ O(M * N)
 * Space Complexity: O(M * N * 4) ~ O(M * N)
 */
package com.null7ptr.lc.lvl3.lc0562;

public class SolutionApproachDP {
    public int longestLine(int[][] matrix) {
        // sanity check
        if(matrix == null || matrix.length == 0) return 0;
        
        final int NR = matrix.length, NC = matrix[0].length;
        
        int[][][] dp = new int[NR][NC][4];
        int maxLen = 0;
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(matrix[row][col] == 1){   // to ignore zeros
                    // rows
                    dp[row][col][0] = (row > 0 && matrix[row - 1][col] == 1) ? dp[row - 1][col][0] + 1: 1;
                    
                    // columns
                    dp[row][col][1] = (col > 0 && matrix[row][col - 1] == 1) ? dp[row][col - 1][1] + 1 : 1;
                    
                    // diagonals
                    dp[row][col][2] = (row > 0 && col > 0 && matrix[row - 1][col - 1] == 1) ? dp[row - 1][col - 1][2] + 1 : 1;
                    
                    // anti-diagonals
                    dp[row][col][3] = (row > 0 && col < NC - 1 && matrix[row - 1][col + 1] == 1) ? dp[row - 1][col + 1][3] + 1 : 1;
                }
                
                for(int k = 0; k < 4; k++){
                    maxLen = Math.max(maxLen, dp[row][col][k]);
                }
            }
        }
        
        return maxLen;
    }
}