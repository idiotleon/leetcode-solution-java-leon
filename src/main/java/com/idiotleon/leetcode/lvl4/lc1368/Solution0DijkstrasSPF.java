package com.idiotleon.leetcode.lvl4.lc1368;

import java.util.Arrays;
import java.util.PriorityQueue;

import static com.idiotleon.util.Constant.WARNING.UNUSED;

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@SuppressWarnings(UNUSED)
public class Solution0DijkstrasSPF {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        final int NR = grid.length, NC = grid[0].length;
        PriorityQueue<Position> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        minHeap.offer(new Position(0, 0, 0));

        int[][] costs = new int[NR][NC];
        for (int[] row : costs) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        costs[0][0] = 0;

        while (!minHeap.isEmpty()) {
            Position cur = minHeap.poll();
            int row = cur.row, col = cur.col;
            int cost = cur.cost;
            if (costs[row][col] != cost) {
                continue;
            }

            for (int d = 0; d < 4; ++d) {
                int r = row + DIRS[d][0], c = col + DIRS[d][1];
                if (r < 0 || r >= NR || c < 0 || c >= NC) continue;

                int newCost = cost;
                if (grid[row][col] != (d + 1)) ++newCost;
                if (costs[r][c] > newCost) {
                    costs[r][c] = newCost;
                    minHeap.offer(new Position(r, c, newCost));
                }
            }
        }

        return costs[NR - 1][NC - 1];
    }

    private static final class Position {
        private final int row;
        protected final int col;
        protected final int cost;

        protected Position(final int row, final int col, final int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
}