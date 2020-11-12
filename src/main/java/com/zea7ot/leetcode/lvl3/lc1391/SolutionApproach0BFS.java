/**
 * https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
 * 
 * Time Complexity:     O(`NR` * `NC`)
 * Space Complexity:    O(`NR` * `NC`)
 * 
 * References:
 *  https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/discuss/547371/Java-clean-BFS
 */
package com.zea7ot.leetcode.lvl3.lc1391;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0BFS {
    final int[][][] DIRS = { { { 0, -1 }, { 0, 1 } }, { { -1, 0 }, { 1, 0 } }, { { 0, -1 }, { 1, 0 } },
            { { 0, 1 }, { 1, 0 } }, { { 0, -1 }, { -1, 0 } }, { { -1, 0 }, { 0, 1 } } };

    public boolean hasValidPath(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return false;

        final int NR = grid.length, NC = grid[0].length;

        Deque<int[]> queue = new ArrayDeque<int[]>();
        queue.add(new int[] { 0, 0 });

        boolean[][] visited = new boolean[NR][NC];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int sz = 0; sz < SIZE; ++sz) {
                int[] top = queue.poll();
                int row = top[0], col = top[1];

                for (final int[] DIR : DIRS[grid[row][col] - 1]) {
                    int nextRow = row + DIR[0], nextCol = col + DIR[1];
                    if (nextRow < 0 || nextRow >= NR || nextCol < 0 || nextCol >= NC || visited[nextRow][nextCol])
                        continue;

                    for (final int[] BACK : DIRS[grid[nextRow][nextCol] - 1]) {
                        if (nextRow + BACK[0] == row && nextCol + BACK[1] == col) {
                            visited[nextRow][nextCol] = true;
                            queue.add(new int[] { nextRow, nextCol });
                        }
                    }
                }
            }
        }

        return visited[NR - 1][NC - 1];
    }
}