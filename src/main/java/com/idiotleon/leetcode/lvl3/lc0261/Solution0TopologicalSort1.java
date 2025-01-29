package com.idiotleon.leetcode.lvl3.lc0261;

import java.util.*;

import static com.idiotleon.util.Constant.WARNING.UNUSED;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/graph-valid-tree/">lc0261</a>
 * Time Complexity:     O(n + edges.length)
 * Space Complexity:    O(n + edges.length)
 */
@SuppressWarnings(UNUSED)
public class Solution0TopologicalSort1 {
    public boolean validTree(final int n, final int[][] edges) {
        // to build up the graph
        final Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        final Deque<Integer> queue = new ArrayDeque<>();
        for (int key : graph.keySet()) {
            if (graph.get(key).size() == 1) {
                queue.add(key);
            }
        }

        // to topological sort
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            if (graph.get(node).isEmpty()) {
                continue;
            }
            final int parent = graph.get(node).iterator().next();
            // --indegree[i]
            graph.get(parent).remove(node);
            // to reduce traversal, by removing empty Map<>.entry
            graph.remove(node);
            if (graph.get(parent).size() == 1) {
                queue.add(parent);
            }
            ++count;
        }

        if (count == n - 1) {
            return true;
        }
        return false;
    }
}