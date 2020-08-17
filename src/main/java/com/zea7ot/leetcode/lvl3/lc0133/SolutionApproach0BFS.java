/**
 * https://leetcode.com/problems/clone-graph/
 * 
 * Time Complexity:     O(V + E) ~ O(N + (N - 1)) ~ O(N)
 * Space Complexity:    O(V + E) ~ O(N + (N - 1)) ~ O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0133;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import com.zea7ot.utils.data_structure.graph.Vertex;

public class SolutionApproach0BFS {
    public Vertex cloneGraph(Vertex node) {
        // sanity check
        if (node == null)
            return node;

        Map<Vertex, Vertex> visited = new HashMap<Vertex, Vertex>();
        Deque<Vertex> queue = new ArrayDeque<Vertex>();
        queue.add(node);

        visited.put(node, new Vertex(node.val, new ArrayList<Vertex>()));

        while (!queue.isEmpty()) {
            Vertex cur = queue.poll();

            for (Vertex neighbor : cur.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Vertex(neighbor.val, new ArrayList<Vertex>()));
                    queue.add(neighbor);
                }

                visited.get(cur).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}