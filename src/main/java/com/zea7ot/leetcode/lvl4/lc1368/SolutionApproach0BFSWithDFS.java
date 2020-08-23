/**
 * https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 * 
 * Core Logic:
 * Find out all reachable nodes without changing anything.
 *  Save all new visited nodes to a queue bfs.
 *  Now iterate the queue
 *  3.1 For each node, try changing it to all 3 other direction
 *  3.2 Save the new reachable and not visited nodes to the queue.
 *  3.3 repeat step 3
 * 
 * References:
 *  https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/discuss/524820/Java-2-different-solutions-Clean-code
 *  https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/discuss/524886/JavaC%2B%2BPython-BFS-and-DFS
 */
package com.zea7ot.leetcode.lvl4.lc1368;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class SolutionApproach0BFSWithDFS {
    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minCost(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        final int NR = grid.length, NC = grid[0].length;

        int cost = 0;

        int[][] dp = new int[NR][NC];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        Deque<int[]> queue = new ArrayDeque<int[]>();
        dfs(grid, 0, 0, dp, cost, queue);
        while (!queue.isEmpty()) {
            ++cost;

            final int SIZE = queue.size();
            for (int i = 0; i < SIZE; i++) {
                int[] cur = queue.poll();
                int row = cur[0], col = cur[1];
                for (final int[] DIR : DIRS) {
                    dfs(grid, row + DIR[0], col + DIR[1], dp, cost, queue);
                }
            }
        }

        return dp[NR - 1][NC - 1];
    }

    private void dfs(int[][] grid, int row, int col, int[][] dp, int cost, Queue<int[]> queue) {
        final int NR = grid.length, NC = grid[0].length;
        if (row < 0 || row >= NR || col < 0 || col >= NC || dp[row][col] != Integer.MAX_VALUE)
            return;
        dp[row][col] = cost;

        queue.offer(new int[] { row, col });

        int nextDir = grid[row][col] - 1;
        dfs(grid, row + DIRS[nextDir][0], col + DIRS[nextDir][1], dp, cost, queue);
    }
}