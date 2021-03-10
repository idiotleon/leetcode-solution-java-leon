/**
 * https://leetcode.com/problems/the-maze/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 */
package com.an7one.leetcode.lvl3.lc0490;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SolutionApproach0BFS {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // sanity check
        if (maze == null || maze.length == 0)
            return false;

        // boundaries
        final int NR = maze.length, NC = maze[0].length;

        // BFS
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(start);

        boolean[][] visited = new boolean[NR][NC];
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int sz = 0; sz < SIZE; ++sz) {
                int[] cur = queue.poll();
                if (Arrays.equals(cur, destination))
                    return true;

                int curRow = cur[0];
                int curCol = cur[1];

                for (int d = 0; d < 4; ++d) {
                    int nextRow = curRow, nextCol = curCol;

                    while (isValid(nextRow + DIRS[d], nextCol + DIRS[d + 1], maze)) {
                        nextRow += DIRS[d];
                        nextCol += DIRS[d + 1];
                    }

                    if (visited[nextRow][nextCol])
                        continue;

                    queue.add(new int[] { nextRow, nextCol });
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return false;
    }

    private boolean isValid(int row, int col, int[][] maze) {
        final int NR = maze.length, NC = maze[0].length;
        return row >= 0 && row < NR && col >= 0 && col < NC && maze[row][col] == 0;
    }
}