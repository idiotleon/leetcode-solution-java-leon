/**
 * https://leetcode.com/problems/is-graph-bipartite/
 * 
 * Time Complexity:     O(V + E) + O(N) ~ O(2 * N) + O(N) ~ O(N)
 * Space Complexity:    O(V + E) + O(N) ~ O(2 * N) + O(N) ~ O(N)
 */
package com.an7one.leetcode.lvl3.lc0785;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0BFS1 {
    private static final int NOT_YET_COLORED = 0;

    public boolean isBipartite(int[][] graph) {
        // sanity check
        if (graph == null || graph.length == 0)
            return false;

        final int N = graph.length;
        int[] colors = new int[N];

        for (int i = 0; i < N; ++i) { // to make sure each node is visited, including disconnected ones
            if (colors[i] != NOT_YET_COLORED)
                continue;

            if (!isValid(i, colors, graph))
                return false;
        }

        return true;
    }

    private boolean isValid(int node, int[] colors, int[][] graph) {
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.add(node);

        int color = 1;

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; i++) {
                int cur = queue.poll();
                if (colors[cur] == NOT_YET_COLORED) {
                    colors[cur] = color;
                    for (int next : graph[cur])
                        queue.add(next);

                } else if (colors[cur] != color)
                    return false;
            }

            // to flip the `color`
            color = -color;
        }

        return true;
    }
}