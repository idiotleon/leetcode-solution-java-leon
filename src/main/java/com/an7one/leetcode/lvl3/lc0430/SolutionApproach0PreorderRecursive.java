/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/discuss/302421/Java-pre-order-and-post-order-solution-same-idea-with-114.-Flatten-Binary-Tree-to-Linked-List
 */
package com.an7one.leetcode.lvl3.lc0430;

public class SolutionApproach0PreorderRecursive {
    private Node prev = null;

    public Node flatten(Node head) {
        // sanity check
        if (head == null)
            return head;

        Node child = head.child;
        Node next = head.next;
        if (prev != null) {
            prev.next = head;
            head.prev = prev;
            prev.child = null;
        }

        prev = head;
        flatten(child);
        flatten(next);
        return head;
    }
}