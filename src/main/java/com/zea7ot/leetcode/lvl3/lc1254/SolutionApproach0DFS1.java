/**
 * https://leetcode.com/problems/number-of-closed-islands/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-closed-islands/discuss/425150/JavaC%2B%2B-with-picture-Number-of-Enclaves
 */
package com.zea7ot.leetcode.lvl3.lc1254;

public class SolutionApproach0DFS1 {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };

    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        final int NR = grid.length, NC = grid[0].length;
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (row == 0 || col == 0 || row == NR - 1 || col == NC - 1) {
                    fill(row, col, grid);
                }
            }
        }

        int count = 0;
        for (int row = 0; row < NR; row++) {
            for (int col = 0; col < NC; col++) {
                if (grid[row][col] == 0) {
                    count++;
                    fill(row, col, grid);
                }
            }
        }

        return count;
    }

    private void fill(int row, int col, int[][] grid) {
        final int NR = grid.length, NC = grid[0].length;
        if (row < 0 || row >= NR || col < 0 || col >= NC || grid[row][col] == 1)
            return;
        grid[row][col] = 1;
        for (int d = 0; d < 4; d++) {
            int r = row + DIRS[d], c = col + DIRS[d + 1];
            fill(r, c, grid);
        }
    }
}