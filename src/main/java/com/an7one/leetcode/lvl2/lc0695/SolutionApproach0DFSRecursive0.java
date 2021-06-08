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
public class SolutionApproach0DFSRecursive0 {
    private final static int[] DIRS = {0, -1, 0, 1, 0};
    private final static int WATER = 0;
    private final static int ISLAND = 1;

    public int maxAreaOfIsland(int[][] grid) {
        final int NR = grid.length, NC = grid[0].length;

        int maxArea = 0;

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (grid[row][col] == WATER) continue;
                int area = dfs(row, col, grid);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    private int dfs(final int row, final int col, final int[][] grid) {
        final int NR = grid.length, NC = grid[0].length;

        if (row < 0 || row >= NR || col < 0 || col >= NC || grid[row][col] != ISLAND)
            return 0;

        grid[row][col] = WATER;
        int area = 1;

        for (int d = 0; d < 4; ++d) {
            final int nextRow = row + DIRS[d], nextCol = col + DIRS[d + 1];
            area += dfs(nextRow, nextCol, grid);
        }

        return area;
    }
}
