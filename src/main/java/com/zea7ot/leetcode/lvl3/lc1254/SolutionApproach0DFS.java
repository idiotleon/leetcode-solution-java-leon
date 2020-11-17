/**
 * https://leetcode.com/problems/number-of-closed-islands/
 * 
 * Time Complexity:     O(`NR` * `NC`)
 * Space Complexity:    O(`NR` * `NC`)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-closed-islands/discuss/425135/Java-Very-Simple-DFS-Solution
 *  https://leetcode.com/problems/number-of-closed-islands/discuss/425135/Java-Very-Simple-DFS-Solution/383149
 */
package com.zea7ot.leetcode.lvl3.lc1254;

public class SolutionApproach0DFS {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };

    public int closedIsland(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        final int NR = grid.length, NC = grid[0].length;
        int count = 0;
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (grid[row][col] == 0) {
                    if (dfs(row, col, grid)) {
                        ++count;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int row, int col, int[][] grid) {
        final int NR = grid.length, NC = grid[0].length;
        if (row < 0 || row >= NR || col < 0 || col >= NC)
            return false;

        if (grid[row][col] == 1)
            return true;
        grid[row][col] = 1;

        boolean res = true;
        for (int d = 0; d < 4; ++d) {
            int nextRow = row + DIRS[d], nextCol = col + DIRS[d + 1];
            if (!dfs(nextRow, nextCol, grid)) {
                res = false;
            }
        }
        return res;
    }
}