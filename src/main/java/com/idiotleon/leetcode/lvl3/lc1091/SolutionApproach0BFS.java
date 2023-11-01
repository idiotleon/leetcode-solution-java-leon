package com.idiotleon.leetcode.lvl3.lc1091;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/shortest-path-in-binary-matrix/">LC1091/a>
 * <p>
 * Time Complexity:     O(N * N)
 * Space Complexity:    O(8) ~ O(1)
 * O(8), consumed by the queue
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS {
    private static final int[][] DIRS = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        final int N = grid.length;
        // sanity check
        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1) {
            return -1;
        }

        final Deque<int[]> queue = new ArrayDeque<>();
        int count = 0;
        queue.addLast(new int[]{0, 0});

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();
            count++;

            for (int i = 0; i < SIZE; ++i) {
                final int[] cur = queue.removeFirst();

                final int row = cur[0], col = cur[1];
                if (row == N - 1 && col == N - 1) {
                    return count;
                }

                grid[row][col] = 1;
                for (int[] DIR : DIRS) {
                    final int r = row + DIR[0], c = col + DIR[1];
                    if (r < 0 || r >= N || c < 0 || c >= N || grid[r][c] == 1) {
                        continue;
                    }
                    grid[r][c] = 1;
                    queue.add(new int[]{r, c});
                }
            }
        }

        return -1;
    }
}