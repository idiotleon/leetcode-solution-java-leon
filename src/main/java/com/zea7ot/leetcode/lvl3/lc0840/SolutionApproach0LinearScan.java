/**
 * https://leetcode.com/problems/magic-squares-in-grid/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(16) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/magic-squares-in-grid/discuss/133938/Java-8-ms-Straightforward-and-Ugly-Solution
 */
package com.zea7ot.leetcode.lvl3.lc0840;

public class SolutionApproach0LinearScan {
    public int numMagicSquaresInside(int[][] grid) {
        final int NR = grid.length, NC = grid[0].length;

        int count = 0;
        for (int row = 0; row <= NR - 3; ++row) {
            for (int col = 0; col <= NC - 3; ++col) {
                if (isMagic(row, col, grid)) {
                    ++count;
                }
            }
        }

        return count;
    }

    private boolean isMagic(int row, int col, int[][] grid) {
        if (grid[row + 1][col + 1] != 5)
            return false;

        int[] isValid = new int[16];
        for (int r = row; r <= row + 2; ++r) {
            for (int c = col; c <= col + 2; ++c) {
                ++isValid[grid[r][c]];
            }
        }

        for (int v = 1; v <= 9; ++v) {
            if (isValid[v] != 1) {
                return false;
            }
        }

        if (grid[row][col] + grid[row][col + 1] + grid[row][col + 2] != 15)
            return false;
        if (grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] != 15)
            return false;
        if (grid[row][col] + grid[row + 1][col] + grid[row + 2][col] != 15)
            return false;
        if (grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2] != 15)
            return false;
        if (grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2] != 15)
            return false;
        if (grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] != 15)
            return false;
        return true;
    }
}
