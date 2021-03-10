/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl2.lc0083;

import com.an7one.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0LinearScan {
    public ListNode deleteDuplicates(ListNode head) {
        // sanity check
        if (head == null || head.next == null)
            return head;

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}