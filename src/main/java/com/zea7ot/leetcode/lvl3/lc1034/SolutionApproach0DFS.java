/**
 * https://leetcode.com/problems/coloring-a-border/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/coloring-a-border/discuss/283262/JavaPython-3-BFS-and-DFS-codes
 */
package com.zea7ot.leetcode.lvl3.lc1034;

public class SolutionApproach0DFS {
    private static final int[] DIRS = {0, -1, 0, 1, 0};
    
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        // sanity check
        if(grid == null || grid.length == 0 || grid[0].length == 0) return grid;

        final int NR = grid.length, NC = grid[0].length;
        dfs(r0, c0, grid[r0][c0], grid);
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(grid[row][col] < 0){
                    grid[row][col] = color;
                }
            }
        }
        return grid;
    }
    
    private void dfs(int row, int col, int color, int[][] grid){
        final int NR = grid.length, NC = grid[0].length;
        grid[row][col] = -color;
        int count = 0;
        for(int d = 0; d < 4; d++){
            int r = row + DIRS[d], c = col + DIRS[d + 1];
            if(r < 0 || r >= NR || c < 0 || c >= NC || Math.abs(grid[r][c]) != color) continue;
            ++count;
            if(grid[r][c] == color) dfs(r, c, color, grid);
        }
        if(count == 4) grid[row][col] = color;
    }
}