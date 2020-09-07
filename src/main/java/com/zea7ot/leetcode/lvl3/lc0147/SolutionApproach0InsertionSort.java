/**
 * https://leetcode.com/problems/insertion-sort-list/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0147;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;

public class SolutionApproach0InsertionSort {
    public ListNode insertionSortList(ListNode head) {
        // sanity check
        if (head == null)
            return head;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (head != null) {
            ListNode next = head.next;

            // to reset `prev`
            if (prev.val >= head.val)
                prev = dummy;

            // to find the right place to insert
            while (prev.next != null && prev.next.val < head.val)
                prev = prev.next;

            // to insert the new node, between `prev` and `prev.next`
            head.next = prev.next;
            prev.next = head;
            head = next;
        }

        return dummy.next;
    }
}