/**
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
 * 
 * Time Complexity:     O(SIZE(buildings) * NR * NC) ~ O((NR * NC) ^ 2)
 * Space Complexity:    O(NR * NC) + O(SIZE(buildings)) ~ O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/shortest-distance-from-all-buildings/discuss/76886/Share-a-Java-implement
 */
package com.an7one.leetcode.lvl4.lc0317;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SolutionApproach0BFS {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };

    private static final int BUILDING = 1;

    public int shortestDistance(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        final int NR = grid.length, NC = grid[0].length;

        List<Building> buildings = new ArrayList<Building>();
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (grid[row][col] == BUILDING)
                    buildings.add(new Building(row, col, 0));

                grid[row][col] = -grid[row][col];
            }
        }

        final int SIZE = buildings.size();
        int[][] distances = new int[NR][NC];
        for (int k = 0; k < SIZE; ++k)
            bfs(buildings.get(k), k, distances, grid);

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

    private void bfs(Building building, int reaches, int[][] distances, int[][] grid) {
        final int NR = grid.length, NC = grid[0].length;

        Deque<Building> queue = new ArrayDeque<Building>();
        queue.add(building);

        while (!queue.isEmpty()) {
            Building cur = queue.poll();
            distances[cur.row][cur.col] += cur.distance;

            for (int d = 0; d < 4; ++d) {
                int r = cur.row + DIRS[d], c = cur.col + DIRS[d + 1];
                if (r < 0 || r >= NR || c < 0 || c >= NC || grid[r][c] != reaches)
                    continue;

                grid[r][c] = reaches + 1;
                queue.add(new Building(r, c, cur.distance + 1));
            }
        }
    }

    private class Building {
        protected int row;
        protected int col;
        protected int distance;

        protected Building(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
}