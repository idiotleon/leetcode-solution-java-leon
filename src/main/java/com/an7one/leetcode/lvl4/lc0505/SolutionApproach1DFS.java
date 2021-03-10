/**
 * https://leetcode.com/problems/the-maze-ii/
 * 
 * Time Complexity:     O(NR * NC * max(NR, NC))
 * Space Complexity:    O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/the-maze-ii/solution/
 */
package com.an7one.leetcode.lvl4.lc0505;

import java.util.Arrays;

public class SolutionApproach1DFS {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // sanity check
        if (maze == null || maze.length == 0 || maze[0].length == 0)
            return -1;

        final int NR = maze.length, NC = maze[0].length;
        int[][] distances = new int[NR][NC];
        for (int[] row : distances)
            Arrays.fill(row, Integer.MAX_VALUE);
        distances[start[0]][start[1]] = 0;

        dfs(start, distances, maze);
        return distances[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1
                : distances[destination[0]][destination[1]];
    }

    private void dfs(int[] cur, int[][] distances, int[][] maze) {
        for (int d = 0; d < 4; ++d) {
            int r = cur[0], c = cur[1];
            int steps = 0;
            while (isValid(r + DIRS[d], c + DIRS[d + 1], maze)) {
                r += DIRS[d];
                c += DIRS[d + 1];
                ++steps;
            }

            if (distances[cur[0]][cur[1]] + steps < distances[r][c]) {
                distances[r][c] = distances[cur[0]][cur[1]] + steps;
                dfs(new int[] { r, c }, distances, maze);
            }
        }
    }

    private boolean isValid(int row, int col, int[][] maze) {
        final int NR = maze.length, NC = maze[0].length;
        return row >= 0 && row < NR && col >= 0 && col < NC && maze[row][col] == 0;
    }
}