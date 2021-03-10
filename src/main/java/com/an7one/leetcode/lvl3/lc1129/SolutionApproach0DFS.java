/**
 * https://leetcode.com/problems/shortest-path-with-alternating-colors/
 * 
 * Time Complexity:     O(V + E)
 * Space Complexity:    O(V + E)
 * 
 * References:
 *  https://leetcode.com/problems/shortest-path-with-alternating-colors/discuss/340246/Java-DFS-and-BFS-two-codes-each-wo-duplication-check.
 */
package com.an7one.leetcode.lvl3.lc1129;

import java.util.Arrays;

public class SolutionApproach0DFS {
    private static final int COLOR_RED = 0;
    private static final int COLOR_BLUE = 1;
    private static final int NOT_EXISTS = -1;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[][] paths = new int[2][n];
        Arrays.fill(paths[COLOR_RED], 1, n, Integer.MAX_VALUE);
        Arrays.fill(paths[COLOR_BLUE], 1, n, Integer.MAX_VALUE);

        dfs(0, COLOR_RED, 0, redEdges, blueEdges, paths);
        dfs(0, COLOR_BLUE, 0, redEdges, blueEdges, paths);

        // to get the shorter one with regard to both colors
        for (int i = 1; i < n; ++i) {
            int shorter = Math.min(paths[COLOR_RED][i], paths[COLOR_BLUE][i]);
            paths[0][i] = shorter == Integer.MAX_VALUE ? NOT_EXISTS : shorter;
        }

        return paths[0];
    }

    private void dfs(int cur, int curColor, int steps, int[][] redEdges, int[][] blueEdges, int[][] paths) {
        int[][] edges = curColor == COLOR_RED ? redEdges : blueEdges;
        int otherColor = curColor == COLOR_RED ? COLOR_BLUE : COLOR_RED;

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            if (cur == from && paths[otherColor][to] > 1 + steps) {
                paths[otherColor][to] = 1 + steps;
                dfs(to, otherColor, 1 + steps, redEdges, blueEdges, paths);
            }
        }
    }
}
