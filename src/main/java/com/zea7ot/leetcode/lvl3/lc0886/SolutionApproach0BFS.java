/**
 * https://leetcode.com/problems/possible-bipartition/
 * 
 * Time Complexity: O(V + E) ~ O(N + dislikes.length)
 * Space Complexity: O(V + E) ~ O(N + dislikes.length)
 * 
 * References:
 *  https://leetcode.com/problems/possible-bipartition/discuss/159085/java-adj
 */
package com.zea7ot.leetcode.lvl3.lc0886;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SolutionApproach0BFS {
    private static final int NOT_YET_COLORED = 0;
    private static final int COLORED = 7;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        // sanity check
        if (N <= 0)
            return false;

        List<List<Integer>> graph = buildGraph(N, dislikes);

        int[] colors = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (colors[i] != NOT_YET_COLORED)
                continue;

            colors[i] = COLORED;
            if (!isValid(i, colors, graph))
                return false;
        }

        return true;
    }

    private boolean isValid(int node, int[] colors, List<List<Integer>> graph) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        colors[node] = COLORED;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (colors[next] == NOT_YET_COLORED) {
                    colors[next] = -colors[cur];
                    queue.add(next);
                } else if (colors[next] == colors[cur])
                    return false;
            }
        }

        return true;
    }

    private List<List<Integer>> buildGraph(final int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>(N + 1);

        for (int i = 0; i <= N; ++i)
            graph.add(new ArrayList<Integer>());

        for (int[] dislike : dislikes) {
            int u = dislike[0], v = dislike[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}