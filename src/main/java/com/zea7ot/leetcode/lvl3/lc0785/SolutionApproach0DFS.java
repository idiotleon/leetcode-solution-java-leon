/**
 * https://leetcode.com/problems/is-graph-bipartite/
 * 
 * Time Complexity:     O(V + E) + O(N) ~ O(2 * N) + O(N) ~ O(N)
 * Space Complexity:    O(V + E) + O(N) ~ O(2 * N) + O(N) ~ O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0785;

public class SolutionApproach0DFS {
    private static final int NOT_YET_COLORED = 0;
    private static final int COLORED = 7;

    public boolean isBipartite(int[][] graph) {
        // sanity check
        if (graph == null || graph.length == 0)
            return false;

        final int N = graph.length;
        int[] colors = new int[N];

        for (int i = 0; i < N; ++i) {
            // to check each node that is not visited, this graph might be disconnected
            if (colors[i] != NOT_YET_COLORED)
                continue;
                
            if (!isValidColor(i, COLORED, colors, graph))
                return false;
        }

        return true;
    }

    private boolean isValidColor(int cur, final int COLOR, int[] colors, int[][] graph) {
        if (colors[cur] != 0)
            return colors[cur] == COLOR;

        colors[cur] = COLOR;
        for (int next : graph[cur]) {
            if (!isValidColor(next, -COLOR, colors, graph))
                return false;
        }

        return true;
    }
}