package com.an7one.leetcode.lvl2.lc0695;

import com.an7one.util.Constant;

/**
 * @author: Leon
 * https://leetcode.com/problems/max-area-of-island/
 * <p>
 * Time Complexity:     O(`NR` * `NC`)
 * Time Complexity:     O(`NR` * `NC`)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive1 {
    private static final int[] DIRS = {0, -1, 0, 1, 0};

    private static final int WATER = 0;
    private static final int ISLAND = 1;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        final int NR = grid.length, NC = grid[0].length;

        int[] maxArea = {0};

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                int[] curAea = {0};
                dfs(row, col, grid, curAea, maxArea);
            }
        }

        return maxArea[0];
    }

    private void dfs(int row, int col, int[][] grid, int[] curArea, int[] maxArea) {
        final int NR = grid.length, NC = grid[0].length;
        if (row < 0 || row >= NR || col < 0 || col >= NC || grid[row][col] != ISLAND)
            return;

        grid[row][col] = WATER;
        maxArea[0] = Math.max(maxArea[0], ++curArea[0]);

        for (int d = 0; d < 4; ++d) {
            int r = row + DIRS[d], c = col + DIRS[d + 1];
            dfs(r, c, grid, curArea, maxArea);
        }
    }
}