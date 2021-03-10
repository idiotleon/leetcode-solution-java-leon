/**
 * https://leetcode.com/problems/clone-graph/
 * 
 * Time Complexity:     O(V + E) + O(N) ~ O(N + (N - 1)) + O(N) ~ O(N)
 * Space Complexity:    O(V + E) + O(N) ~ O(N + (N - 1)) + O(N) ~ O(N)
 */
package com.an7one.leetcode.lvl3.lc0133;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0BFS {
    public Node cloneGraph(Node Node) {
        // sanity check
        if (Node == null)
            return Node;

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(Node);

        Map<Node, Node> map = new HashMap<>();
        map.put(Node, new Node(Node.val));

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                Node cur = queue.poll();

                for (Node neighbor : cur.neighbors) {
                    if (!map.containsKey(neighbor)) {
                        Node clonedNeighbor = new Node(neighbor.val);
                        map.put(neighbor, clonedNeighbor);
                        queue.add(neighbor);
                    }

                    map.get(cur).neighbors.add(map.get(neighbor));
                }
            }
        }

        return map.get(Node);
    }
}