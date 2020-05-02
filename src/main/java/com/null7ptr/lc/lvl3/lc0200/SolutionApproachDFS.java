/**
 * https://leetcode.com/problems/number-of-islands/
 */
package com.null7ptr.lc.lvl3.lc0200;

public class SolutionApproachDFS {
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int NR, NC;
    
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        if(grid == null || grid.length == 0) return numIslands;
        
        NR = grid.length;
        NC = grid[0].length;
        
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(grid[row][col] == '1'){
                    ++numIslands;
                    dfs(grid, row, col);
                }
            }
        }
        
        return numIslands;
    }
    
    private void dfs(char[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= NR || col >= NC || grid[row][col] == '0') return;
        
        grid[row][col] = '0';
        
        for(int[] dir : DIRS){
            int r = row + dir[0], c = col + dir[1];
            dfs(grid, r, c);
        }
    }
}