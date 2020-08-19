/**
 * https://leetcode.com/problems/max-area-of-island/
 * 
 * condition 1:
 *  0: Island
 *  1: Water
 * 
 * to return the starting position of the islands of the max area
 */
package com.zea7ot.leetcode.lvl2.lc0695.followups;

public class SolutionApproach0DFS {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };

    private static final int ISLAND = 0;
    // private static final int WATER = 1;

    public int[] maxAreaOfIsland(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return new int[] { -1, -1 };

        final int NR = grid.length, NC = grid[0].length;

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                int[] area = { 0 };
                dfs(row, col, grid, area);
            }
        }

        int ansRow = 0, ansCol = 0;
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (Math.abs(grid[row][col]) > grid[ansRow][ansCol]) {
                    ansRow = row;
                    ansCol = col;
                }
            }
        }

        return new int[] { ansRow, ansCol };
    }

    private void dfs(int row, int col, int[][] grid, int[] area) {
        final int NR = grid.length, NC = grid[0].length;
        if (row < 0 || row >= NR || col < 0 || col >= NC || grid[row][col] != ISLAND)
            return;

        grid[row][col] = -(++area[0]);

        for (int d = 0; d < 4; ++d) {
            int r = row + DIRS[d], c = col + DIRS[d + 1];
            dfs(r, c, grid, area);
        }
    }
}