package com.idiotleon.leetcode.lvl3.lc0802;

import com.idiotleon.util.Constant;

import java.util.*;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/find-eventual-safe-states/">Description<a>
 * <p>
 * Time Complexity:     O(V + E) ~ O(`N` + numEdges)
 * Space Complexity:    O(V + E) ~ O(`N` + numEdges)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class Solution0KahnsAlgorithm {
    public List<Integer> eventualSafeNodes(final int[][] graph) {
        final List<Integer> ans = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return ans;
        }

        final int N = graph.length;
        final int[] indegrees = new int[N];
        final List<List<Integer>> adj = buildGraph(graph, indegrees);

        final Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; ++i) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.removeFirst();
            ans.add(cur);

            for (int parent : adj.get(cur)) {
                if (--indegrees[parent] == 0) {
                    queue.addLast(parent);
                }
            }
        }

        Collections.sort(ans);

        return ans;
    }

    private List<List<Integer>> buildGraph(final int[][] graph, final int[] indegrees) {
        final int N = graph.length;
        final List<List<Integer>> adj = new ArrayList<>(N);
        for (int i = 0; i < N; ++i) {
            adj.add(new ArrayList<>());
        }

        for (int parent = 0; parent < N; ++parent) {
            final int len = graph[parent].length;
            for (int child : graph[parent]) {
                adj.get(child).add(parent);
            }

            indegrees[parent] = len;
        }

        return adj;
    }
}