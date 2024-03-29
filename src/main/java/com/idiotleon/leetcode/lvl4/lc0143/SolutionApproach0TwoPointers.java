/**
 * https://leetcode.com/problems/reorder-list/
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(L / 2) ~ O(L)
 */
package com.idiotleon.leetcode.lvl4.lc0143;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.linkedlist.ListNode;

@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0TwoPointers {
    public void reorderList(ListNode head) {
        // sanity check
        if (head == null || head.next == null) return;

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