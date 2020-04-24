/**
 * https://leetcode.com/problems/longest-increasing-paths-in-a-matrix/
 * 
 * DFS + memorization (Top Down)
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N)
 */
package main.java.lcidiot.lc.lvl4.lc0329;

import java.util.Arrays;

public class SolutionApproachMemorizedDFS {
    private static final int[] DIRS = {0, -1, 0, 1, 0};
    private int nr, nc;
    
    public int longestIncreasingPath(int[][] matrix) {
        // sanity check
        if(matrix == null || matrix.length == 0) return 0;
        
        // boundaries of int[][] matrix
        nr = matrix.length;
        nc = matrix[0].length;
        
        int ans = 0;
        int[][] paths = new int[nr][nc];
        for(int[] path : paths){
            Arrays.fill(path, -1);
        }

        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
                ans = Math.max(ans, longestIncreasingPath(matrix, row, col, paths));
            }
        }
        
        return ans;
    }
    
    private int longestIncreasingPath(int[][] matrix, int row, int col, int[][] paths){
        if(paths[row][col] != -1) return paths[row][col];

        paths[row][col] = 1;
        for(int i = 0; i < 4; i++){
            int r = row + DIRS[i], c = col + DIRS[i + 1];
            if(r < 0 || r >= nr || c < 0 || c >= nc || matrix[r][c] <= matrix[row][col]) continue;
            paths[row][col] = Math.max(paths[row][col], 1 + longestIncreasingPath(matrix, r, c, paths));
        }
        
        return paths[row][col];
    }
}