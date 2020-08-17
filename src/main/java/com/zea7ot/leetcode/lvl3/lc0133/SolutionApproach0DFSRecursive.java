/**
 * https://leetcode.com/problems/clone-graph/
 * 
 * Time Complexity:     O(V + E) ~ O(N + (N - 1)) ~ O(N)
 * Space Complexity:    O(V + E) ~ O(N + (N - 1)) ~ O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0133;

import java.util.HashMap;
import java.util.Map;

import com.zea7ot.utils.data_structure.graph.Vertex;

public class SolutionApproach0DFSRecursive {
    public Vertex cloneGraph(Vertex node) {
        // sanity check
        if (node == null)
            return node;

        Map<Vertex, Vertex> visited = new HashMap<Vertex, Vertex>();
        return dfs(node, visited);
    }

    private Vertex dfs(Vertex node, Map<Vertex, Vertex> visited) {
        if (node == null)
            return node;

        if (visited.containsKey(node))
            return visited.get(node);

        Vertex clone = new Vertex(node.val);
        visited.put(node, clone);

        for (Vertex neighbor : node.neighbors)
            clone.neighbors.add(dfs(neighbor, visited));

        return clone;
    }
}