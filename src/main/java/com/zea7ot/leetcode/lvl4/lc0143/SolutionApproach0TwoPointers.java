/**
 * https://leetcode.com/problems/reorder-list/
 * 
 * Time Complexity:     O(L)
 * Space Compleixty:    O(L / 2) ~ O(L)
 */
package com.zea7ot.leetcode.lvl4.lc0143;

import com.zea7ot.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0TwoPointers {
    public void reorderList(ListNode head) {
        // sanity check
        if (head == null || head.next == null)
            return;

        // step 1: to cut the list into two halves
        ListNode mid = getMidAndBreak(head);
        ListNode firstHalf = head;

        // step 2: to reverse the 2nd half
        ListNode latterHalf = reverse(mid);

        // step 3: to merge the two halves
        mergeInTurns(firstHalf, latterHalf);
    }

    private ListNode getMidAndBreak(ListNode head) {
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head, next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    private void mergeInTurns(ListNode head1, ListNode head2) {
        while (head2 != null) {
            ListNode next = head1.next;
            head1.next = head2;
            head1 = head2;
            head2 = next;
        }
    }
}