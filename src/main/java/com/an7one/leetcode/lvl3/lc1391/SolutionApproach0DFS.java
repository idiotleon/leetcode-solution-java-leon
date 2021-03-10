/**
 * https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
 * 
 * Time Complexity:     O(`NR` * `NC`)
 * Space Complexity:    O(`NR` * `NC`)
 * 
 * Reference:
 *  https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/discuss/553574/Java-DFS-Solution-Clean-code
 */
package com.an7one.leetcode.lvl3.lc1391;

public class SolutionApproach0DFS {
    final int[][][] STREETS = { { { 0, -1 }, { 0, 1 } }, { { -1, 0 }, { 1, 0 } }, { { 0, -1 }, { 1, 0 } },
            { { 0, 1 }, { 1, 0 } }, { { 0, -1 }, { -1, 0 } }, { { -1, 0 }, { 0, 1 } } };

    public boolean hasValidPath(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return false;

        final int NR = grid.length, NC = grid[0].length;
        boolean[][] visited = new boolean[NR][NC];
        return dfs(0, 0, visited, grid);
    }

    private boolean dfs(int row, int col, boolean[][] visited, int[][] grid) {
        final int NR = grid.length, NC = grid[0].length;
        if (row == NR - 1 && col == NC - 1)
            return true;

        visited[row][col] = true;
        for (final int[] DIR : STREETS[grid[row][col] - 1]) {
            int nextRow = row + DIR[0], nextCol = col + DIR[1];
            if (nextRow < 0 || nextRow >= NR || nextCol < 0 || nextCol >= NC || visited[nextRow][nextCol])
                continue;

            for (final int[] BACK : STREETS[grid[nextRow][nextCol] - 1]) {
                if (nextRow + BACK[0] == row && nextCol + BACK[1] == col) {
                    if (dfs(nextRow, nextCol, visited, grid))
                        return true;
                }
            }
        }

        return false;
    }
}