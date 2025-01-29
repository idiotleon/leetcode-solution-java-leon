package com.idiotleon.leetcode.lvl3.lc0261;

import java.util.ArrayList;
import java.util.List;

import static com.idiotleon.util.Constant.WARNING.UNUSED;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/graph-valid-tree/">lc0261</a>
 * <p>
 * Time Complexity:     O(n + edges.length)
 * Space Complexity:    O(n + edges.length)
 */
@SuppressWarnings(UNUSED)
public class Solution0DfsRecursive {
    public boolean validTree(final int n, final int[][] edges) {
        // to build up the graph
        final List<List<Integer>> graph = new ArrayList<>();
        // to initialize the graph
        for (int i = 0; i < n; ++i) {
            graph.add(i, new ArrayList<>());
        }

        // to add edges
        for (int[] edge : edges) {
            final int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        final boolean[] visited = new boolean[n];

        if (hasCycle(0, -1, visited, graph)) {
            return false;
        }

        // to make sure that all vertices are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    // to check if an undirected graph has cycle starting from vertex u
    private boolean hasCycle(final int cur, final int prev, final boolean[] visited, final List<List<Integer>> graph) {
        if (visited[cur]) {
            return true;
        }

        visited[cur] = true;

        for (int next : graph.get(cur)) {
            if (next != prev && hasCycle(next, cur, visited, graph)) {
                return true;
            }
        }

        return false;
    }
}