/**
 * https://leetcode.com/problems/number-of-closed-islands/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-closed-islands/discuss/426294/JavaPython-3-DFS-BFS-and-Union-Find-codes-w-brief-explanation-and-analysis.
 */
package com.zea7ot.leetcode.lvl3.lc1254;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0BFS {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };
    private int NR, NC;

    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        NR = grid.length;
        NC = grid[0].length;

        Set<Integer> seen = new HashSet<Integer>();
        int count = 0;
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (grid[row][col] == 0 && seen.add(hash(row, col))) {
                    count += bfs(row, col, grid, seen);
                }
            }
        }
        return count;
    }

    private int bfs(int row, int col, int[][] grid, Set<Integer> seen) {
        final int NR = grid.length, NC = grid[0].length;

        int res = 1;
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(hash(row, col));

        while (!queue.isEmpty()) {
            int top = queue.poll();

            for (int d = 0; d < 4; d++) {
                int r = top / NC + DIRS[d], c = top % NC + DIRS[d + 1];
                if (r < 0 || r >= NR || c < 0 || c >= NC)
                    res = 0;
                else if (grid[r][c] == 0 && seen.add(hash(r, c))) {
                    queue.offer(hash(r, c));
                }
            }
        }

        return res;
    }

    private int hash(int row, int col) {
        return row * NC + col;
    }
}