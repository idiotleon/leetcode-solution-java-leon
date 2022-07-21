package com.an7one.leetcode.lvl3.lc0092;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.linkedlist.ListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/">LC0092</a>
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/discuss/30666/Simple-Java-solution-with-clear-explanation/221870">LC Discussion</a>
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/discuss/30666/Simple-Java-solution-with-clear-explanation">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0LinearScan1 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        final ListNode dummy = new ListNode(-1);
        ListNode prev = dummy, cur = head;
        dummy.next = head;

        int idx = 1;
        while (idx < m) {
            prev = cur;
            cur = cur.next;
            ++idx;
        }

        ListNode node = prev;
        while (idx <= n) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            ++idx;
        }

        node.next.next = cur;
        node.next = prev;

        return dummy.next;
    }
}