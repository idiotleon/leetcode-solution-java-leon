/**
 * https://leetcode.com/problems/clone-graph/
 * 
 * Time Complexity:     O(V + E) + O(N) ~ O(N + (N - 1)) ~ O(N)
 * Space Complexity:    O(V + E) + O(N) ~ O(N + (N - 1)) ~ O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0133;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DFSIterative {
    public Node cloneGraph(Node node) {
        // sanity check
        if (node == null)
            return node;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(node);

        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));

        while (!stack.isEmpty()) {
            Node top = stack.pop();
            for (Node neighbor : top.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    stack.push(neighbor);
                }

                map.get(top).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}