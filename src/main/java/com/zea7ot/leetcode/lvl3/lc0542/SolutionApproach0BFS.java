/**
 * https://leetcode.com/problems/01-matrix/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 */
package com.zea7ot.leetcode.lvl3.lc0542;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0BFS {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };

    public int[][] updateMatrix(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return matrix;

        final int NR = matrix.length, NC = matrix[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (matrix[row][col] == 0) {
                    queue.offer(new int[] { row, col });
                } else {
                    matrix[row][col] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];

                for (int d = 0; d < 4; ++d) {
                    int r = row + DIRS[d], c = col + DIRS[d + 1];

                    if (r < 0 || r >= NR || c < 0 || c >= NC || matrix[r][c] != Integer.MAX_VALUE)
                        continue;

                    queue.offer(new int[] { r, c });
                    matrix[r][c] = matrix[row][col] + 1;
                }
            }
        }

        return matrix;
    }
}