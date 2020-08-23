/**
 * https://leetcode.com/problems/longest-increasing-paths-in-a-matrix/
 * 
 * a top-down approach
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 */
package com.zea7ot.leetcode.lvl4.lc0329;

import java.util.Arrays;

public class SolutionApproach0DFSMemo {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };

    public int longestIncreasingPath(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        // boundaries of int[][] matrix
        final int NR = matrix.length, NC = matrix[0].length;

        int longest = 0;
        int[][] paths = new int[NR][NC];
        for (int[] path : paths)
            Arrays.fill(path, -1);

        for (int row = 0; row < NR; ++row)
            for (int col = 0; col < NC; ++col)
                longest = Math.max(longest, dfs(row, col, matrix, paths));

        return longest;
    }

    private int dfs(int row, int col, int[][] matrix, int[][] paths) {
        final int NR = matrix.length, NC = matrix[0].length;

        if (paths[row][col] != -1)
            return paths[row][col];

        paths[row][col] = 1;
        for (int d = 0; d < 4; ++d) {
            int r = row + DIRS[d], c = col + DIRS[d + 1];
            if (r < 0 || r >= NR || c < 0 || c >= NC || matrix[r][c] <= matrix[row][col])
                continue;
            paths[row][col] = Math.max(paths[row][col], 1 + dfs(r, c, matrix, paths));
        }

        return paths[row][col];
    }
}