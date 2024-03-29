package com.idiotleon.leetcode.lvl3.lc0708;

import com.idiotleon.util.Constant;

/**
 * https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * <p>
 * References:
 * https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/discuss/163141/Share-my-concise-JAVA-one-pass-solution/209124
 * https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/discuss/163141/Share-my-concise-JAVA-one-pass-solution
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0OnePass {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node cur = new Node(insertVal);
            cur.next = cur;
            return cur;
        }

        Node prev = head;
        Node cur = head.next;

        while (cur != head) {
            int prevVal = prev.val;
            int nextVal = cur.val;

            if (insertVal == prevVal
                    || (prevVal < insertVal && insertVal <= nextVal)
                    || (nextVal < prevVal && prevVal < insertVal)
                    || (insertVal < nextVal && nextVal < prevVal)) {
                break;
            }

            prev = cur;
            cur = cur.next;
        }

        Node node = new Node(insertVal);
        prev.next = node;
        node.next = cur;
        return head;
    }
}