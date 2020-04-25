/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * 
 * https://www.youtube.com/watch?v=yKr4iyQnBpY
 * 
 * DP (Bottom Up)
 * Time Complexity: O(MN * MN) -> O(MN * lg(MN))
 */
package com.null7ptr.lc.lvl4.lc0329;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionApproachDP1 {
    private static final int[] DIRS = {0, 1, 0, -1, 0};
    private int nr, nc;
    
    public int longestIncreasingPath(int[][] matrix) {
        // sanity check
        if(matrix == null || matrix.length == 0) return 0;
        
        // boundaries of int[][] matrix
        nr = matrix.length;
        nc = matrix[0].length;
        
        int[][] dp = new int[nr][nc];
        for(int[] arr : dp){
            Arrays.fill(arr, 1);
        }
        
        List<int[]> cells = new ArrayList<int[]>();
        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
                 cells.add(new int[]{matrix[row][col], row, col});
            }
        }
        
        Collections.sort(cells, (e1, e2) -> e2[0] - e1[0]);
        
        int ans = 0;
        for(int[] cell : cells){
            int row = cell[1], col = cell[2];
            
            for(int i = 0; i < 4; i++){
                int r = row + DIRS[i], c = col + DIRS[i + 1];
                if(r < 0 || r >= nr || c < 0 || c >= nc || matrix[r][c] <= matrix[row][col]) continue;
                dp[row][col] = Math.max(dp[row][col], 1 + dp[r][c]);
            }
            
            ans = Math.max(ans, dp[row][col]);
        }

        return ans;
    }
}