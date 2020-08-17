/**
 * https://leetcode.com/problems/island-perimeter/
 */
package com.zea7ot.leetcode.lvl2.lc0463;

public class SolutionApproachDFS {
    private static final int[] DIRS = {0, -1, 0, 1, 0};
    private int NR, NC;
    
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        NR = grid.length;
        NC = grid[0].length;
        
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(grid[row][col] == 1){
                    return getPerimeter(grid, row, col);
                }
            }
        }
        
        return 0;
    }
    
    private int getPerimeter(int[][] grid, int row, int col){
        if(row < 0 || row >= NR || col < 0 || col >= NC) return 1;
        if(grid[row][col] == 0) return 1;
        
        if(grid[row][col] == -1) return 0;
        
        int count = 0;
        grid[row][col] = -1;
        
        for(int i = 0; i < 4; i++){
            int r = row + DIRS[i], c = col + DIRS[i + 1];
            count += getPerimeter(grid, r, c);
        }
        
        return count;
    }
}