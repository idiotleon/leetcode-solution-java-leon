/**
 * https://leetcode.com/problems/clone-graph/
 * 
 * Time Complexity:     O(V + E) ~ O(N + (N - 1)) ~ O(N)
 * Space Complexity:    O(V + E) ~ O(N + (N - 1)) ~ O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0133;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import com.zea7ot.utils.data_structure.graph.Vertex;

public class SolutionApproach0DFSIterative {
    public Vertex cloneGraph(Vertex vertex) {
        // sanity check
        if (vertex == null)
            return vertex;

        Deque<Vertex> stack = new ArrayDeque<Vertex>();
        stack.push(vertex);

        Map<Vertex, Vertex> map = new HashMap<Vertex, Vertex>();
        map.put(vertex, new Vertex(vertex.val));

        while (!stack.isEmpty()) {
            Vertex top = stack.pop();
            for (Vertex neighbor : top.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Vertex(neighbor.val));
                    stack.push(neighbor);
                }

                map.get(top).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(vertex);
    }
}