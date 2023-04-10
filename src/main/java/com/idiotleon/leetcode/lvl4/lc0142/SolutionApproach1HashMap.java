/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
package com.idiotleon.leetcode.lvl4.lc0142;

import java.util.HashSet;
import java.util.Set;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.linkedlist.ListNode;

@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1HashMap {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        ListNode node = head;
        while (node != null) {
            if (visited.contains(node)) return node;
            visited.add(node);
            node = node.next;
        }

        return null;
    }
}