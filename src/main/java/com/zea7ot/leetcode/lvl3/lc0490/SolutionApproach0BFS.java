/**
 * https://leetcode.com/problems/the-maze/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    ?O(NR * NC)
 */
package com.zea7ot.leetcode.lvl3.lc0490;

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
        Deque<int[]> queue = new ArrayDeque<int[]>();
        queue.add(start);

        boolean[][] visited = new boolean[NR][NC];
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (Arrays.equals(cur, destination))
                return true;

            for (int d = 0; d < 4; ++d) {
                int r = cur[0], c = cur[1];

                while (isValid(r + DIRS[d], c + DIRS[d + 1], maze)) {
                    r += DIRS[d];
                    c += DIRS[d + 1];
                }

                if (visited[r][c])
                    continue;
                visited[r][c] = true;
                queue.add(new int[] { r, c });
            }
        }

        return false;
    }

    private boolean isValid(int row, int col, int[][] maze) {
        final int NR = maze.length, NC = maze[0].length;
        return row >= 0 && row < NR && col >= 0 && col < NC && maze[row][col] == 0;
    }
}