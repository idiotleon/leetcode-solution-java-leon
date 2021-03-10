/**
 * https://leetcode.com/problems/island-perimeter/
 * 
 * Time Complexity:     O((NR * NC) ^ 2)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl2.lc0463;

public class SolutionApproach1DFSNaive {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        final int NR = grid.length, NC = grid[0].length;

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (grid[row][col] == 1) {
                    return getPerimeter(row, col, grid);
                }
            }
        }

        return 0;
    }

    private int getPerimeter(int row, int col, int[][] grid) {
        final int NR = grid.length, NC = grid[0].length;
        if (row < 0 || row >= NR || col < 0 || col >= NC)
            return 1;
        if (grid[row][col] == 0)
            return 1;

        if (grid[row][col] == -1)
            return 0;

        int count = 0;
        grid[row][col] = -1;

        for (int i = 0; i < 4; i++) {
            int r = row + DIRS[i], c = col + DIRS[i + 1];
            count += getPerimeter(r, c, grid);
        }

        return count;
    }
}