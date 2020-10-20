/**
 * https://leetcode.com/problems/graph-valid-tree/
 * 
 * Time Complexity: O(N + M)
 * Space Complexity: O(N + M)
 */
package com.zea7ot.leetcode.lvl3.lc0261;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0TopologicalSort {
    public boolean validTree(int n, int[][] edges) {
        List<Set<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
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
            int node = queue.removeFirst();
            if (graph.get(node).size() == 0)
                continue;
            int parent = graph.get(node).iterator().next();
            // --indegree[i]
            graph.get(parent).remove(node);
            if (graph.get(parent).size() == 1) {
                queue.add(parent);
            }
            count++;
        }

        return count == n - 1;
    }
}