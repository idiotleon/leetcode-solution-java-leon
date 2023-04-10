package com.idiotleon.leetcode.lvl3.lc0200;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/number-of-islands/">LC0200</a>
 * <p>
 * Time Complexity:     O(`NR` * `NC`)
 * Space Complexity:    O(`NR` * `NC`)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS {
    private static final int[] DIRS = {0, -1, 0, 1, 0};

    private static final char WATER = '0';
    private static final char LAND = '1';

    public int numIslands(char[][] grid) {
        int islands = 0;
        // sanity check, not required
        // if (grid == null || grid.length == 0)
        // return islands;

        final int NR = grid.length, NC = grid[0].length;

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (grid[row][col] == LAND) {
                    ++islands;
                    bfs(row, col, grid);
                }
            }
        }

        return islands;
    }

    private void bfs(int row, int col, final char[][] GRID) {
        final int NR = GRID.length, NC = GRID[0].length;

        final Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{row, col});

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int sz = 0; sz < SIZE; ++sz) {
                int[] cur = queue.removeFirst();
                int curRow = cur[0];
                int curCol = cur[1];

                for (int d = 0; d < 4; ++d) {
                    int nextRow = curRow + DIRS[d], nextCol = curCol + DIRS[d + 1];

                    if (nextRow < 0 || nextCol < 0 || nextRow >= NR || nextCol >= NC || GRID[nextRow][nextCol] == WATER)
                        continue;
                    GRID[nextRow][nextCol] = WATER;
                    queue.addLast(new int[]{nextRow, nextCol});
                }
            }
        }
    }
}