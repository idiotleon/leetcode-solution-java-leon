/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/discuss/157606/Java-Recursive-Solution/569288
 *  https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/discuss/157606/Java-Recursive-Solution
 */
package com.zea7ot.leetcode.lvl3.lc0430;

public class SolutionApproach0Recursion {
    public Node flatten(Node head) {
        // sanity check
        if (head == null)
            return null;
        flattenTail(head);
        return head;
    }

    private Node flattenTail(Node cur) {
        if (cur.child != null) {
            Node tail = flattenTail(cur.child);
            tail.next = cur.next;
            if (cur.next != null) {
                cur.next.prev = tail;
            }
            cur.next = cur.child;
            cur.child.prev = cur;
            cur.child = null;
        }

        if (cur.next == null)
            return cur;
        return flattenTail(cur.next);
    }
}