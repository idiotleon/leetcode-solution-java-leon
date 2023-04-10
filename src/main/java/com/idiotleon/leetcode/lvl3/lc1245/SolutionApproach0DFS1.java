/**
 * https://leetcode.com/problems/tree-diameter/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/tree-diameter/discuss/418820/(Java)-Using-2-BFS
 *  https://leetcode.com/problems/tree-diameter/discuss/418820/(Java)-Using-2-BFS/402688
 *  https://stackoverflow.com/a/29219346/6061609
 */
package com.idiotleon.leetcode.lvl3.lc1245;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0DFS1 {
    public int treeDiameter(int[][] edges) {
        // sanity check
        if (edges == null || edges.length < 1)
            return 0;

        // best[0]: the length
        // best[1]: the starting node
        int[] best = { -1, -1 };
        Map<Integer, List<Integer>> graph = buildGraph(edges);

        dfs(0, -1, 0, graph, best);
        dfs(best[1], -1, 0, graph, best);

        return best[0];
    }

    private void dfs(int cur, int parent, int len, Map<Integer, List<Integer>> graph, int[] best) {
        if (len > best[0]) {
            best[0] = len;
            best[1] = cur;
        }
        // not working,
        // as `best` is not a class member variable
        // if(len > best[0])
        // best = new int[]{len, cur};

        for (int next : graph.get(cur)) {
            if (next == parent)
                continue;
            dfs(next, cur, len + 1, graph, best);
        }
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