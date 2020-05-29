/**
 * https://leetcode.com/problems/regions-cut-by-slashes/
 * 
 * Time Complexity: O(NR * NC) ~ O(N ^ 2)
 * Space Complexity: O(NR * NC) ~ O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/regions-cut-by-slashes/discuss/205674/C%2B%2B-with-picture-DFS-on-upscaled-grid
 * 
 * Similar Problems:
 *  https://leetcode.com/problems/number-of-islands/
 *  https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 */
package com.polyg7ot.lc.lvl5.lc0959;

import java.util.Arrays;

public class SolutionApproach0DFS {
    private static final int[] DIRS = {0, -1, 0, 1, 0};
    private int NR, NC;
    
    public int regionsBySlashes(String[] grid) {
        final int N = grid.length;
        NR = NC = 3 * N;
        
        // to build up the graph
        boolean[][] map = new boolean[NR][NC];
        for(boolean[] row : map) Arrays.fill(row, true);
        for(int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
                if(grid[row].charAt(col) == '/'){
                    map[3 * row + 2][3 * col] = map[3 * row + 1][3 * col + 1] = map[3 * row][3 * col + 2] = false;
                }
                
                if(grid[row].charAt(col) == '\\'){
                    map[3 * row][3 * col] = map[3 * row + 1][3 * col + 1] = map[3 * row + 2][3 * col + 2] = false;
                }
            }
        }
        
        int count = 0;
        // to DFS
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(map[row][col]){
                    count++;
                    dfs(map, row, col);
                }
            }
        }
        
        return count;
    }
    
    private void dfs(boolean[][] map, int row, int col){
        if(row < 0 || row >= NR || col < 0 || col >= NC || !map[row][col]) return;
        
        map[row][col] = false;
        
        for(int d = 0; d < 4; d++){
            int r = row + DIRS[d], c = col + DIRS[d + 1];
            dfs(map, r, c);
        }
    }
}