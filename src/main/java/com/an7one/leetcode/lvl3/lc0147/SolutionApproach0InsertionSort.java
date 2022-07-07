package com.an7one.leetcode.lvl3.lc0147;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.linkedlist.ListNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/insertion-sort-list/">LC0147</a>
 * <p>
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0InsertionSort {
    public ListNode insertionSortList(ListNode head) {
        // sanity check
        if (head == null)
            return head;

        final ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (head != null) {
            final ListNode next = head.next;

            // to reset `prev`
            if (prev.val >= head.val) {
                prev = dummy;
            }

            // to find the right place to insert
            while (prev.next != null && prev.next.val < head.val) {
                prev = prev.next;
            }

            // to insert the new node, between `prev` and `prev.next`
            head.next = prev.next;
            prev.next = head;
            head = next;
        }

        return dummy.next;
    }
}