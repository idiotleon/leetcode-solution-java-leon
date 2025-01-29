package com.idiotleon.leetcode.lvl3.lc0261;

import java.util.*;

import static com.idiotleon.util.Constant.WARNING.UNUSED;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/graph-valid-tree/">lc0261</a>
 * Time Complexity:     O(N + M)
 * Space Complexity:    O(N + M)
 */
@SuppressWarnings(UNUSED)
public class Solution0TopologicalSort {
    public boolean validTree(final int n, final int[][] edges) {
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (final int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        final Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            // isolated nodes, if ever been found
            // (1, []) is expected to return true
            // if(graph[i].size() == 0) return false;
            // eligible (leaf) nodes, with only 1 parent
            if (graph.get(i).size() == 1) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            final int node = queue.removeFirst();
            if (graph.get(node).isEmpty()) {
                continue;
            }
            final int parent = graph.get(node).iterator().next();
            // --indegree[i]
            graph.get(parent).remove(node);
            if (graph.get(parent).size() == 1) {
                queue.add(parent);
            }
            ++count;
        }

        return count == n - 1;
    }
}