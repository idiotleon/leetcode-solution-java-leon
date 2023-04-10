/**
 * https://leetcode.com/problems/all-paths-from-source-lead-to-destination/
 * 
 * Time Complexity:     O(E + V)
 * Space Complexity:    O(E + V)
 * 
 * References:
 *  https://leetcode.com/problems/all-paths-from-source-lead-to-destination/discuss/303566/Java-DFS-with-cycle-detection-(5ms)
 */
package com.idiotleon.leetcode.lvl3.lc1059;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DFS {
    private enum State {
        PROCESSING, PROCESSED
    };

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = buildGraph(edges, n);
        return dfs(source, destination, new State[n], graph);
    }

    private boolean dfs(int node, int destination, State[] states, List<List<Integer>> graph) {
        if (states[node] != null)
            return states[node] == State.PROCESSED;
        if (graph.get(node).isEmpty())
            return node == destination;

        states[node] = State.PROCESSING;
        for (int next : graph.get(node)) {
            if (!dfs(next, destination, states, graph))
                return false;
        }
        states[node] = State.PROCESSED;

        return true;
    }

    private List<List<Integer>> buildGraph(int[][] edges, int n) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        return graph;
    }
}