/**
 * https://leetcode.com/problems/walls-and-gates/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 */
package com.an7one.leetcode.lvl3.lc0286;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0BFS {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };
    private static final int EMPTY = Integer.MAX_VALUE;
    // not used
    // private static final int WALL = -1;
    private static final int GATE = 0;

    public void wallsAndGates(int[][] rooms) {
        // sanity check
        if (rooms == null || rooms.length == 0)
            return;

        // boundaries
        final int NR = rooms.length, NC = rooms[0].length;

        // BFS
        Deque<int[]> queue = new ArrayDeque<int[]>();
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (rooms[row][col] == GATE)
                    queue.add(new int[] { row, col });
            }
        }

        int steps = 1;
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; i++) {
                int[] cur = queue.poll();

                for (int d = 0; d < 4; ++d) {
                    int r = cur[0] + DIRS[d], c = cur[1] + DIRS[d + 1];
                    if (r < 0 || c < 0 || r >= NR || c >= NC || rooms[r][c] != EMPTY)
                        continue;

                    rooms[r][c] = steps;
                    queue.add(new int[] { r, c });
                }
            }

            ++steps;
        }
    }
}