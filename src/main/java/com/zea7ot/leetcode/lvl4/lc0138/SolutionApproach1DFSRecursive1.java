/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.zea7ot.leetcode.lvl4.lc0138;

import java.util.HashMap;

public class SolutionApproach1DFSRecursive1 {
    private HashMap<Node, Node> visited = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        if (visited.containsKey(head))
            return this.visited.get(head);

        Node node = new Node(head.val);
        visited.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}