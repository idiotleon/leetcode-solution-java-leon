package com.idiotleon.leetcode.lvl3.lc0092;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.linkedlist.ListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/">LC0092</a>
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity;    O(L)
 * <p>
 * Reference:
 * https://leetcode.com/problems/reverse-linked-list-ii/discuss/30673/Why-nobody-does-it-with-recursion-shouldn't-the-code-be-simpler
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive1 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;

        if (m > 1) {
            ListNode newHead = head;
            newHead.next = reverseBetween(head.next, m - 1, n - 1);
            return newHead;
        } else { // when `m == 1`, it means there is no need in further moving
            ListNode next = head.next;
            ListNode newHead = reverseBetween(next, 1, n - 1);
            ListNode tail = next.next;
            next.next = head;
            head.next = tail;
            return newHead;
        }
    }
}
