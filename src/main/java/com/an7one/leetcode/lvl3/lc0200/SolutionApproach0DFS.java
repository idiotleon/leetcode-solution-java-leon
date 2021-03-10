/**
 * @author: Leon
 * https://leetcode.com/problems/number-of-islands/
 * 
 * Time Complexity:     O(`NR` * `NC`)
 * Space Complexity:    O(`NR` * `NC`)
 */
package com.an7one.leetcode.lvl3.lc0200;

public class SolutionApproach0DFS {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };

    private static final char WATER = '0';
    private static final char LAND = '1';

    public int numIslands(char[][] grid) {
        int islands = 0;
        // sanity check, not required
        // if (grid == null || grid.length == 0)
        // return islands;

        final int NR = grid.length, NC = grid[0].length;

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (grid[row][col] == LAND) {
                    ++islands;
                    dfs(row, col, grid);
                }
            }
        }

        return islands;
    }

    private void dfs(int row, int col, final char[][] GRID) {
        final int NR = GRID.length, NC = GRID[0].length;
        if (row < 0 || col < 0 || row >= NR || col >= NC || GRID[row][col] == WATER)
            return;

        GRID[row][col] = WATER;

        for (int d = 0; d < 4; ++d) {
            int nextRow = row + DIRS[d], nextCol = col + DIRS[d + 1];
            dfs(nextRow, nextCol, GRID);
        }
    }
}