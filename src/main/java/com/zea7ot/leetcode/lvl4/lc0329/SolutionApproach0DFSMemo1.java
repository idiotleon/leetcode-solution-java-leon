/**
 * https://leetcode.com/problems/longest-increasing-paths-in-a-matrix/
 * 
 * DFS + memoization (Top Down)
 * 
 * Time Complexity:     O(M * N)
 * Space Complexity:    O(M * N)
 */
package com.zea7ot.leetcode.lvl4.lc0329;

public class SolutionApproach0DFSMemo1 {
    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int longestIncreasingPath(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        // boundaries of int[][] matrix
        final int NR = matrix.length, NC = matrix[0].length;

        int longest = 0;
        // DFS - memory
        int[][] paths = new int[NR][NC];
        // DFS
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                longest = Math.max(longest, dfs(row, col, matrix, paths));
            }
        }

        return longest;
    }

    private int dfs(int row, int col, int[][] matrix, int[][] paths) {
        final int NR = matrix.length, NC = matrix[0].length;
        if (paths[row][col] != 0)
            return paths[row][col];

        for (final int[] DIR : DIRS) {
            int nextRow = row + DIR[0], nextCol = col + DIR[1];
            if (nextRow < 0 && nextRow >= NR && nextCol < 0 && nextCol >= NC)
                continue;

            if (matrix[nextRow][nextCol] > matrix[row][col])
                paths[row][col] = Math.max(paths[row][col], dfs(nextRow, nextCol, matrix, paths));
        }

        return ++paths[row][col];
    }
}