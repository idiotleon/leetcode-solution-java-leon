/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/discuss/302421/Java-pre-order-and-post-order-solution-same-idea-with-114.-Flatten-Binary-Tree-to-Linked-List
 */
package com.zea7ot.leetcode.lvl3.lc0430;

public class SolutionApproach0PostorderRecursive {
    private Node prev = null;

    public Node flatten(Node head) {
        // sanity check
        if (head == null)
            return head;

        flatten(head.next);
        flatten(head.child);

        head.next = prev;
        if (prev != null) {
            prev.prev = head;
        }

        head.child = null;
        prev = head;
        return head;
    }
}