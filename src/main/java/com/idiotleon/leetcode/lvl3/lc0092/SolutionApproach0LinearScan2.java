package com.idiotleon.leetcode.lvl3.lc0092;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.linkedlist.ListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/">LC0092</a>
 * <p>
 * Time Complexity:     O(`n`) ~ O(L)
 * L, length of the linked list
 * <p>
 * Space Complexity:    O(1)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/discuss/30676/6-10-lines-in-C++/404542">LC Discussion</a>
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/discuss/30676/6-10-lines-in-C%2B%2B">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0LinearScan2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        final ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1; i < m; ++i)
            prev = prev.next;

        ListNode pivot = prev.next;
        for (int i = m; i < n; ++i) {
            ListNode next = pivot.next;
            pivot.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}
