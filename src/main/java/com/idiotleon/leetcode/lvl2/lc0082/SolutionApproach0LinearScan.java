/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl2.lc0082;

import com.idiotleon.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0LinearScan {
    public ListNode deleteDuplicates(ListNode head) {
        // sanity check
        if (head == null || head.next == null)
            return head;

        final ListNode DUMMY = new ListNode(-1);
        ListNode prev = DUMMY, cur = head;
        DUMMY.next = head;

        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            if (prev.next == cur) {
                prev = prev.next;
            } else {
                prev.next = cur.next;
            }

            cur = cur.next;
        }

        return DUMMY.next;
    }
}