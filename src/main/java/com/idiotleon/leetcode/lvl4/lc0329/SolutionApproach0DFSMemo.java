/**
 * https://leetcode.com/problems/longest-increasing-memo-in-a-matrix/
 * 
 * a top-down approach
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 */
package com.idiotleon.leetcode.lvl4.lc0329;

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
        int[][] memo = new int[NR][NC];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                longest = Math.max(longest, dfs(row, col, matrix, memo));
            }
        }

        return longest;
    }

    private int dfs(int row, int col, int[][] matrix, int[][] memo) {
        final int NR = matrix.length, NC = matrix[0].length;

        if (memo[row][col] != -1)
            return memo[row][col];

        memo[row][col] = 1;
        for (int d = 0; d < 4; ++d) {
            int nextRow = row + DIRS[d], nextCol = col + DIRS[d + 1];
            if (nextRow < 0 || nextRow >= NR || nextCol < 0 || nextCol >= NC
                    || matrix[nextRow][nextCol] <= matrix[row][col])
                continue;
            memo[row][col] = Math.max(memo[row][col], 1 + dfs(nextRow, nextCol, matrix, memo));
        }

        return memo[row][col];
    }
}