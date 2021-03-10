/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * 
 * Time Complexity:     O(L)
 * Space Complexity;    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/reverse-linked-list-ii/discuss/30673/Why-nobody-does-it-with-recursion-shouldn't-the-code-be-simpler
 */
package com.an7one.leetcode.lvl3.lc0092;

import com.an7one.util.data_structure.linkedlist.ListNode;

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
