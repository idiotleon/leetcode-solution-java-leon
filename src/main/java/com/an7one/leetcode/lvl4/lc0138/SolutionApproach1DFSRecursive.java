/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.an7one.leetcode.lvl4.lc0138;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach1DFSRecursive {
    public Node copyRandomList(Node head) {
        // sanity check
        if (head == null)
            return null;

        Map<Node, Node> map = new HashMap<>();
        dfs(head, map);
        return map.get(head);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        if (node == null)
            return null;

        if (map.containsKey(node))
            return map.get(node);

        Node clone = new Node(node.val);
        map.put(node, clone);

        clone.next = dfs(node.next, map);
        clone.random = dfs(node.random, map);

        return clone;
    }
}