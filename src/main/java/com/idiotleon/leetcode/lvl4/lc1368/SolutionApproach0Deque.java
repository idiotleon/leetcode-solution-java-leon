/**
 * https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 * 
 * this is essentially the same as the BFS + DFS approach
 * 
 * References:
 *  https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/discuss/524820/Java-2-different-solutions-Clean-code/462830
 */
package com.idiotleon.leetcode.lvl4.lc1368;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Deque {
    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minCost(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0)
            return 0;

        final int NR = grid.length, NC = grid[0].length;
        boolean[][] visited = new boolean[NR][NC];
        Deque<int[]> deque = new ArrayDeque<int[]>();
        // idx 0: row
        // idx 1: col
        // idx 2: cost
        deque.add(new int[] { 0, 0, 0 });

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            int row = cur[0], col = cur[1], cost = cur[2];

            if (visited[row][col])
                continue;
            visited[row][col] = true;
            if (row == NR - 1 && col == NC - 1)
                return cost;

            for (int d = 0; d < 4; d++) {
                int r = row + DIRS[d][0], c = col + DIRS[d][1];
                if (r < 0 || r >= NR || c < 0 || c >= NC)
                    continue;
                if (d + 1 == grid[row][col]) {
                    deque.addFirst(new int[] { r, c, cost });
                } else {
                    deque.addLast(new int[] { r, c, cost + 1 });
                }
            }
        }

        return -1;
    }
}