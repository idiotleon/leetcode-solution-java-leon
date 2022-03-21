package com.an7one.leetcode.lvl3.lc0764;

import com.an7one.util.Constant;

import java.util.Arrays;

/**
 * @author: Leon
 * https://leetcode.com/problems/largest-plus-sign/
 *
 * Time Complexity:         O(`N` ^ 2)
 * Space Complexity:        O(`N` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/largest-plus-sign/discuss/113314/JavaC++Python-O(N2)-solution-using-only-one-grid-matrix/114381
 *  https://leetcode.com/problems/largest-plus-sign/discuss/113314/JavaC++Python-O(N2)-solution-using-only-one-grid-matrix/575669
 *  https://leetcode.com/problems/largest-plus-sign/discuss/113314/JavaC%2B%2BPython-O(N2)-solution-using-only-one-grid-matrix
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP2Dimen1 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        final int[][] grid = new int[N][N];
        for (final int[] row : grid) {
            Arrays.fill(row, N);
        }
        for (final int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0, k = N - 1, left = 0, right = 0, up = 0, down = 0; j < N; ++j, --k) {
                grid[i][j] = Math.min(grid[i][j], left = (grid[i][j] == 0 ? 0 : left + 1));
                grid[i][k] = Math.min(grid[i][k], right = (grid[i][k] == 0 ? 0 : right + 1));
                grid[j][i] = Math.min(grid[j][i], up = (grid[j][i] == 0 ? 0 : up + 1));
                grid[k][i] = Math.min(grid[k][i], down = (grid[k][i] == 0 ? 0 : down + 1));
            }
        }

        int max = 0;
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < N; ++col) {
                max = Math.max(max, grid[row][col]);
            }
        }

        return max;
    }
}