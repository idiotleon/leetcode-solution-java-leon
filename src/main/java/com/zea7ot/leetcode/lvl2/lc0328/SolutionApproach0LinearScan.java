/**
 * https://leetcode.com/problems/odd-even-linked-list/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0328;

import com.zea7ot.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0LinearScan {
    public ListNode oddEvenList(ListNode head) {
        final ListNode DUMMY_ODD = new ListNode(-1);
        final ListNode DUMMY_EVEN = new ListNode(-1);
        ListNode prevOdd = DUMMY_ODD, prevEven = DUMMY_EVEN;

        int count = 1;
        while (head != null) {
            if (count % 2 == 1) {
                prevOdd.next = new ListNode(head.val);
                prevOdd = prevOdd.next;
            } else {
                prevEven.next = new ListNode(head.val);
                prevEven = prevEven.next;
            }

            count++;
            head = head.next;
        }

        prevOdd.next = DUMMY_EVEN.next;

        return DUMMY_ODD.next;
    }
}