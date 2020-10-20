/**
 * https://leetcode.com/problems/number-of-distinct-islands/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 */
package com.zea7ot.leetcode.lvl3.lc0694;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0DFS {
    private static final int[] DIRS = new int[] { 0, -1, 0, 1, 0 };
    private static final char[] MOVES = new char[] { 'd', 'l', 'u', 'r' };

    private static final int ISLAND = 1;
    private static final int WATER = 0;

    private static final char START = '&';
    private static final char SPLITTER = '#';

    public int numDistinctIslands(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0)
            return 0;

        final int NR = grid.length, NC = grid[0].length;
        final Set<String> SEEN = new HashSet<>();

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (grid[row][col] == ISLAND) {
                    StringBuilder builder = new StringBuilder();
                    dfs(row, col, builder, START, grid);
                    String signature = builder.toString();
                    SEEN.add(signature);
                }
            }
        }

        return SEEN.size();
    }

    private void dfs(int row, int col, StringBuilder builder, final char MOVE, int[][] grid) {
        final int NR = grid.length, NC = grid[0].length;

        grid[row][col] = 0;
        builder.append(MOVE);
        for (int d = 0; d < 4; ++d) {
            int nextRow = row + DIRS[d], nextCol = col + DIRS[d + 1];
            if (nextRow < 0 || nextCol < 0 || nextRow >= NR || nextCol >= NC || grid[nextRow][nextCol] == WATER)
                continue;
            dfs(nextRow, nextCol, builder, MOVES[d], grid);
        }
        builder.append(SPLITTER);
    }
}