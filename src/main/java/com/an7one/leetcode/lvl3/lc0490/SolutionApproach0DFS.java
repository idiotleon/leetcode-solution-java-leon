/**
 * https://leetcode.com/problems/the-maze/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    ?O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/the-maze/discuss/97067/Simple-Java-DFS-with-comments
 */
package com.an7one.leetcode.lvl3.lc0490;

public class SolutionApproach0DFS {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // sanity check
        if (maze == null || maze.length == 0)
            return false;

        final int NR = maze.length, NC = maze[0].length;
        boolean[][] visited = new boolean[NR][NC];

        return dfs(start[0], start[1], visited, maze, destination);
    }

    private boolean dfs(int row, int col, boolean[][] visited, int[][] maze, int[] destination) {
        if (visited[row][col])
            return false;
        if (row == destination[0] && col == destination[1])
            return true;

        visited[row][col] = true;
        for (int d = 0; d < 4; ++d) {
            int r = row, c = col;
            while (isValid(r + DIRS[d], c + DIRS[d + 1], maze)) {
                r += DIRS[d];
                c += DIRS[d + 1];
            }

            if (dfs(r, c, visited, maze, destination))
                return true;
        }

        return false;
    }

    private boolean isValid(int row, int col, int[][] maze) {
        final int NR = maze.length, NC = maze[0].length;
        return row >= 0 && row < NR && col >= 0 && col < NC && maze[row][col] == 0;
    }
}