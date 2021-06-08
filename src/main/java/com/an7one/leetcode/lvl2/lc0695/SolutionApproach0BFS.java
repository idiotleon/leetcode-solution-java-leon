package com.an7one.leetcode.lvl2.lc0695;

import com.an7one.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/max-area-of-island/
 * <p>
 * Time Complexity:     O(`NR` * `NC`)
 * Time Complexity:     O(`NR` * `NC`)
 * <p>
 * References:
 * https://leetcode.com/problems/max-area-of-island/discuss/186891/Java.-BFSDFSUnion-Find.
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS {
    private static final int[] DIRS = {0, -1, 0, 1, 0};

    // private static final int WATER = 0;
    private static final int ISLAND = 1;

    public int maxAreaOfIsland(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        final int NR = grid.length, NC = grid[0].length;
        boolean[][] visited = new boolean[NR][NC];

        int ans = 0;
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (grid[row][col] == ISLAND && !visited[row][col]) {
                    ans = Math.max(ans, bfs(row, col, visited, grid));
                }
            }
        }

        return ans;
    }

    private int bfs(int row, int col, boolean[][] visited, int[][] grid) {
        final int NR = grid.length, NC = grid[0].length;

        Deque<int[]> queue = new ArrayDeque<int[]>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        int res = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 4; ++d) {
                int r = cur[0] + DIRS[d], c = cur[1] + DIRS[d + 1];
                if (r < 0 || r >= NR || c < 0 || c >= NC || visited[r][c] || grid[r][c] != ISLAND)
                    continue;
                queue.add(new int[]{r, c});
                visited[r][c] = true;
            }

            ++res;
        }

        return res;
    }
}