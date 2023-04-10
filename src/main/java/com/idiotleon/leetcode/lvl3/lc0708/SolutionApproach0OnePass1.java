package com.idiotleon.leetcode.lvl3.lc0708;

import com.idiotleon.util.Constant;

/**
 * https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * <p>
 * References:
 * https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/discuss/163141/Share-my-concise-JAVA-one-pass-solution
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0OnePass1 {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node cur = new Node(insertVal);
            cur.next = cur;
            return cur;
        }

        Node cur = head.next;
        Node prev = head;
        boolean find = false;
        while (cur != head) {
            int nextVal = cur.val;
            int prevVal = prev.val;
            if (insertVal == prevVal
                    || insertVal <= nextVal && insertVal > prevVal
                    || nextVal < prevVal && insertVal > prevVal
                    || nextVal < prevVal && insertVal < nextVal) {
                find = true;
                Node node = new Node(insertVal);
                prev.next = node;
                node.next = cur;
                break;
            }

            prev = cur;
            cur = cur.next;
        }

        if (!find) {
            Node node = new Node(insertVal);
            prev.next = node;
            node.next = cur;
        }

        return head;
    }
}