/**
 * https://leetcode.com/problems/partition-list/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl3.lc0086;

import com.idiotleon.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0LinearScan {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1), dummy2 = new ListNode(-1);
        ListNode cur1 = dummy1, cur2 = dummy2;

        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = head;
            } else {
                cur2.next = head;
                cur2 = head;
            }

            head = head.next;
        }

        cur2.next = null;
        cur1.next = dummy2.next;

        return dummy1.next;
    }
}