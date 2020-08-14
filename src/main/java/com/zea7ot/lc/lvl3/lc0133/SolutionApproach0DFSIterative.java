/**
 * https://leetcode.com/problems/clone-graph/
 * 
 * Time Complexity:     O(V + E) ~ O(N + (N - 1)) ~ O(N)
 * Space Complexity:    O(V + E) ~ O(N + (N - 1)) ~ O(N)
 */
package com.zea7ot.lc.lvl3.lc0133;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import com.zea7ot.utils.data_structure.graph.Vertex;

public class SolutionApproach0DFSIterative {
    public Vertex cloneGraph(Vertex Vertex) {
        // sanity check
        if (Vertex == null)
            return Vertex;

        Deque<Vertex> stack = new ArrayDeque<Vertex>();
        stack.push(Vertex);
        Map<Vertex, Vertex> visited = new HashMap<Vertex, Vertex>();
        visited.put(Vertex, new Vertex(Vertex.val));

        while (!stack.isEmpty()) {
            Vertex top = stack.pop();
            for (Vertex neighbor : top.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Vertex(neighbor.val));
                    stack.push(neighbor);
                }

                visited.get(top).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(Vertex);
    }
}