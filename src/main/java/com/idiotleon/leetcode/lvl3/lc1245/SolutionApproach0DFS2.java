/**
 * https://leetcode.com/problems/tree-diameter/
 * 
 * Time Complexity:     O(V + E) ~ O(2 * edges.length) ~ O(edges.length)
 * Space Complexity:    O(V + E) ~ O(2 * edges.length) ~ O(edges.length)
 * 
 * References:
 *  https://leetcode.com/problems/tree-diameter/discuss/418982/Java-Depth-of-the-Tree-solution-Time-O(N)-Easy-to-understand
 */
package com.idiotleon.leetcode.lvl3.lc1245;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0DFS2 {
    public int treeDiameter(int[][] edges) {
        // sanity check
        if (edges == null || edges.length < 1)
            return 0;

        Map<Integer, List<Integer>> graph = buildGraph(edges);

        int[] diameter = { 0 };
        dfs(0, -1, graph, diameter);
        return diameter[0];
    }

    private int dfs(int cur, int parent, Map<Integer, List<Integer>> graph, int[] diameter) {
        int deepest = 0, secDeepest = 0;
        for (int child : graph.get(cur)) {
            if (child == parent)
                continue;
            int depth = dfs(child, cur, graph, diameter);
            if (depth > deepest) {
                secDeepest = deepest;
                deepest = depth;
            } else if (depth > secDeepest) {
                secDeepest = depth;
            }
        }

        diameter[0] = Math.max(diameter[0], deepest + secDeepest);
        return deepest + 1;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.putIfAbsent(u, new ArrayList<Integer>());
            graph.putIfAbsent(v, new ArrayList<Integer>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}