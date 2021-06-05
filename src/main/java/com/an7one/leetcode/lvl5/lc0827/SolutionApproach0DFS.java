package com.an7one.leetcode.lvl5.lc0827;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/making-a-large-island/
 * <p>
 * Time Complexity:     O((NR * NC) ^ 2)
 * Space Complexity:    O(NR * NC)
 * <p>
 * a very straight forward / brutal force backtrack approach
 * <p>
 * References:
 * https://leetcode.com/problems/making-a-large-island/discuss/127256/DFS-JAVA-AC-CONCISE-SOLUTION/153727
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFS {
    private static final int[] DIRS = {0, -1, 0, 1, 0};

    public int largestIsland(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        final int NR = grid.length, NC = grid[0].length;
        int max = -1;
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (grid[row][col] == 0) {
                    grid[row][col] = 1;
                    max = Math.max(max, dfs(row, col, grid, new boolean[NR][NC]));
                    grid[row][col] = 0;
                }
            }
        }

        return max == -1 ? NR * NC : max;
    }

    private int dfs(int row, int col, int[][] grid, boolean[][] seen) {
        final int NR = grid.length, NC = grid[0].length;
        if (row < 0 || row >= NR || col < 0 || col >= NC || grid[row][col] != 1 || seen[row][col])
            return 0;

        seen[row][col] = true;
        int count = 0;
        for (int d = 0; d < 4; ++d) {
            int r = row + DIRS[d], c = col + DIRS[d + 1];
            count += dfs(r, c, grid, seen);
        }

        return count + 1;
    }
}