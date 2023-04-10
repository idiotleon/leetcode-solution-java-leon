/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.idiotleon.leetcode.lvl4.lc0138;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach1LinearScan {
    public Node copyRandomList(Node head) {
        // sanity check
        if (head == null)
            return null;

        Map<Node, Node> map = new HashMap<>();

        // 1st pass: to copy all the nodes
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        // 2nd pass: to assign next and random pointers
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}