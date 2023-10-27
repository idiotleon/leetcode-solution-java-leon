package com.idiotleon.leetcode.lvl4.lc0317;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/shortest-distance-from-all-buildings/">LC0317</a>
 * <p>
 * Time Complexity:     O(SIZE(buildings) * `NR` * `NC`) ~ O((`NR` * `NC`) ^ 2)
 * Space Complexity:    O(`NR` * `NC`) + O(SIZE(buildings)) ~ O(`NR` * `NC`)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/shortest-distance-from-all-buildings/discuss/76886/Share-a-Java-implement">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS {
    private static final int[] DIRS = {0, -1, 0, 1, 0};

    private static final int BUILDING = 1;

    public int shortestDistance(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        final int NR = grid.length, NC = grid[0].length;

        final List<Building> buildings = new ArrayList<>();
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (grid[row][col] == BUILDING) {
                    buildings.add(new Building(row, col, 0));
                }

                grid[row][col] = -grid[row][col];
            }
        }

        final int SIZE = buildings.size();
        final int[][] distances = new int[NR][NC];
        for (int k = 0; k < SIZE; ++k) {
            bfs(buildings.get(k), k, distances, grid);
        }

        int ans = -1;
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (grid[row][col] == SIZE && (ans < 0 || distances[row][col] < ans)) {
                    ans = distances[row][col];
                }
            }
        }

        return ans;
    }

    private void bfs(final Building building, final int expectedId, final int[][] distances, final int[][] grid) {
        final int NR = grid.length, NC = grid[0].length;

        final Deque<Building> queue = new ArrayDeque<>();
        queue.add(building);

        while (!queue.isEmpty()) {
            final Building cur = queue.poll();
            distances[cur.row][cur.col] += cur.distance;

            for (int d = 0; d < 4; ++d) {
                final int nextRow = cur.row + DIRS[d], nextCol = cur.col + DIRS[d + 1];
                if (nextRow < 0 || nextRow >= NR || nextCol < 0 || nextCol >= NC || grid[nextRow][nextCol] != expectedId) {
                    continue;
                }

                grid[nextRow][nextCol] = expectedId + 1;
                queue.add(new Building(nextRow, nextCol, cur.distance + 1));
            }
        }
    }

    private static class Building {
        private final int row;
        private final int col;
        private final int distance;

        private Building(final int row, final int col, final int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
}