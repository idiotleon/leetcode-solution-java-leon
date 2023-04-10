/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl2.lc0203;

import com.idiotleon.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0LinearScan {
    public ListNode removeElements(ListNode head, int val) {
        // sanity check
        if (head == null)
            return head;

        final ListNode DUMMY = new ListNode(-1);
        ListNode prev = DUMMY;
        DUMMY.next = head;

        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return DUMMY.next;
    }
}