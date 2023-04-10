/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.idiotleon.leetcode.lvl4.lc0138;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach1LinearScan1 {
    public Node copyRandomList(Node head) {
        // sanity check
        if (head == null)
            return head;

        Map<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            if (!map.containsKey(cur))
                map.put(cur, new Node(cur.val));

            if (cur.next != null && !map.containsKey(cur.next))
                map.put(cur.next, new Node(cur.next.val));

            if (cur.random != null && !map.containsKey(cur.random))
                map.put(cur.random, new Node(cur.random.val));

            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}