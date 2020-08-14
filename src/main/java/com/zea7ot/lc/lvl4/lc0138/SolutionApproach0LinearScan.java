/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * Time Complexity:     O(3 * L) ~ O(L)
 * Space Complexity:    O(L) / O(1)
 */
package com.zea7ot.lc.lvl4.lc0138;

public class SolutionApproach0LinearScan {
    public ListNode copyRandomList(ListNode head) {
        if (head == null)
            return null;

        // the first pass
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = new ListNode(cur.val);
            cur.next.next = next;
            cur = next;
        }

        // the second pass
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // the third pass
        cur = head;
        ListNode copyHead = head.next;
        while (cur != null) {
            ListNode next = cur.next.next;
            ListNode copy = cur.next;
            cur.next = next;
            if (next != null)
                copy.next = next.next;
            cur = next;
        }

        return copyHead;
    }
}