/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * 
 * Time Complexity:     O(`n`) ~ O(L)
 *  L, length of the linked list
 * 
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/reverse-linked-list-ii/discuss/30676/6-10-lines-in-C++/404542
 *  https://leetcode.com/problems/reverse-linked-list-ii/discuss/30676/6-10-lines-in-C%2B%2B
 */
package com.zea7ot.leetcode.lvl3.lc0092;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;

public class SolutionApproach0LinearScan2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
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
