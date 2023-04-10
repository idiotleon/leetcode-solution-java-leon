/**
 * https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
 * 
 * Time Complexity:     O(Elg(V)) ~ O((NR * NC) * lg(NR * NC))
 * Space Complexity:    O(NR * NC)
 * 
 * Referneces:
 *  https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/discuss/524820/Java-2-different-solutions-Clean-code
 */
package com.idiotleon.leetcode.lvl4.lc1368;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproach0DijkstrasSPF1 {
    // the order should be aligned with the cost of direction
    // up: 0
    // left: 1
    // down: 2
    // right: 3
    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minCost(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0)
            return 0;

        final int NR = grid.length, NC = grid[0].length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[] { 0, 0, 0 });

        int[][] costs = new int[NR][NC];
        for (int[] row : costs)
            Arrays.fill(row, Integer.MAX_VALUE);
        costs[0][0] = 0;

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int cost = cur[0], row = cur[1], col = cur[2];
            if (costs[row][col] != cost)
                continue;
            for (int d = 0; d < 4; ++d) {
                int r = row + DIRS[d][0], c = col + DIRS[d][1];
                if (r < 0 || r >= NR || c < 0 || c >= NC)
                    continue;

                int newCost = cost;
                if (d != (grid[row][col] - 1))
                    newCost += 1;
                if (costs[r][c] > newCost) {
                    costs[r][c] = newCost;
                    minHeap.offer(new int[] { newCost, r, c });
                }
            }
        }
        return costs[NR - 1][NC - 1];
    }
}