/**
 * https://leetcode.com/problems/clone-graph/
 * 
 * Time Complexity:     O(V + E) ~ O(N + (N - 1)) ~ O(N)
 * Space Complexity:    O(V + E) ~ O(N + (N - 1)) ~ O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DFSRecursive1 {
    private Map<Node, Node> map = new HashMap<Node, Node>();

    public Node cloneGraph(Node node) {
        // sanity check
        if (node == null)
            return node;

        if (map.containsKey(node))
            return map.get(node);

        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}