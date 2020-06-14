/**
 * https://leetcode.com/problems/longest-increasing-paths-in-a-matrix/
 * 
 * DFS + memoization (Top Down)
 * 
 * Time Complexity:     O(M * N)
 * Space Complexity:    O(M * N)
 */
package com.zea7ot.lc.lvl4.lc0329;

public class SolutionApproachDFSMemo1 {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int NR, NC;
    
    public int longestIncreasingPath(int[][] matrix) {
        // sanity check
        if(matrix == null || matrix.length == 0) return 0;
        
        // boundaries of int[][] matrix
        NR = matrix.length;
        NC = matrix[0].length;
        
        int ans = 0;
        // DFS - memory
        int[][] paths = new int[NR][NC];
        // DFS
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                ans = Math.max(ans, longestIncreasingPath(matrix, row, col, paths));
            }
        }
        
        return ans;
    }
    
    private int longestIncreasingPath(int[][] matrix, int row, int col, int[][] paths){
        if(paths[row][col] != 0) return paths[row][col];
        
        for(final int[] DIR : DIRS){
            int r = row + DIR[0], c = col + DIR[1];
            if(r < 0 && r >= NR && c < 0 && c >= NC) continue;
            if(matrix[r][c] > matrix[row][col]){
                paths[row][col] = Math.max(paths[row][col], longestIncreasingPath(matrix, r, c, paths));
            }
        }
        
        return ++paths[row][col];
    }
}