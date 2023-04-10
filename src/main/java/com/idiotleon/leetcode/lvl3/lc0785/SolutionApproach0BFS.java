/**
 * https://leetcode.com/problems/is-graph-bipartite/
 * 
 * Time Complexity:     O(V + E) + O(N) ~ O(2 * N) + O(N) ~ O(N)
 * Space Complexity:    O(V + E) + O(N) ~ O(2 * N) + O(N) ~ O(N)
 */
package com.idiotleon.leetcode.lvl3.lc0785;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0BFS {
    private static final int NOT_YET_COLORED = 0;
    private static final int COLORED = 7;

    public boolean isBipartite(int[][] graph) {
        // sanity check
        if (graph == null || graph.length == 0)
            return false;

        final int N = graph.length;
        int[] colors = new int[N];

        // to make sure that all nodes will be visited, including disconnected ones
        for (int i = 0; i < N; ++i) {
            if (colors[i] != NOT_YET_COLORED)
                continue;

            if (!isValid(i, colors, graph))
                return false;
        }

        return true;
    }

    private boolean isValid(int node, int[] colors, int[][] graph) {
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(node);
        colors[node] = COLORED; // do not forget to initialize the colors array

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int adj : graph[cur]) {
                if (colors[adj] == NOT_YET_COLORED) { // to paint colors
                    queue.add(adj);
                    colors[adj] = -colors[cur];
                } else if (colors[adj] == colors[cur]) // if the colors of cur and adj are the same
                    return false;

            }
        }
        return true;
    }
}