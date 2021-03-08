/**
 * https://leetcode.com/problems/rotate-list/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * to link the tail of the list with the head, making it a circle
 * 
 * References:
 *  https://leetcode.com/problems/rotate-list/discuss/22751/Clean-Java-Solution-with-Brief-Explanation
 */
package com.zea7ot.leetcode.lvl3.lc0061;

import com.zea7ot.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0LinearScan {
    public ListNode rotateRight(ListNode head, int k) {
        // sanity check
        if (head == null)
            return head;

        ListNode copyHead = head;

        int len = 1;
        while (copyHead.next != null) { // to stop right at the tail
            copyHead = copyHead.next;
            ++len;
        }

        // to make the linked list circular
        copyHead.next = head;

        for (int i = len - k % len; i > 1; --i) {
            head = head.next;
        }

        copyHead = head.next;
        // to break the circular linked list
        head.next = null;

        return copyHead;
    }
}