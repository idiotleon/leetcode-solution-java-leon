/**
 * https://leetcode.com/problems/rotting-oranges/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(max(NR, NC))
 */
package com.an7one.leetcode.lvl3.lc0994;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0BFS {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };

    // not used
    // private static final int EMPTY = 0;
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;

    public int orangesRotting(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0)
            return -1;

        final int NR = grid.length, NC = grid[0].length;
        int freshCount = 0;

        Deque<int[]> queue = new ArrayDeque<int[]>();
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (grid[row][col] == ROTTEN) {
                    queue.add(new int[] { row, col });
                } else if (grid[row][col] == FRESH)
                    ++freshCount;
            }
        }

        // there is no fresh oranges at all
        if (freshCount == 0)
            return 0;

        // all are fresh oranges
        if (freshCount == NR * NC)
            return -1;

        int level = 0;
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();
            level++;

            for (int i = 0; i < SIZE; i++) {
                int[] cur = queue.poll();

                for (int d = 0; d < 4; ++d) {
                    int r = cur[0] + DIRS[d], c = cur[1] + DIRS[d + 1];
                    if (r < 0 || c < 0 || r >= NR || c >= NC || grid[r][c] != FRESH)
                        continue;

                    grid[r][c] = ROTTEN;
                    queue.add(new int[] { r, c });
                    if (--freshCount == 0)
                        return level;
                }
            }
        }

        return -1;
    }
}