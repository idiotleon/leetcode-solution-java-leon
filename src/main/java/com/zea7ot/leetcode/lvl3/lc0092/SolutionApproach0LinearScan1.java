/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/reverse-linked-list-ii/discuss/30666/Simple-Java-solution-with-clear-explanation/221870
 *  https://leetcode.com/problems/reverse-linked-list-ii/discuss/30666/Simple-Java-solution-with-clear-explanation
 */
package com.zea7ot.leetcode.lvl3.lc0092;

import com.zea7ot.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0LinearScan1 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
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