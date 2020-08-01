/**
 * https://leetcode.com/problems/rotate-list/
 * 
 * to link the tail of the list with the head, making it a circle
 */
package com.zea7ot.lc.lvl3.lc0061;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // sanity check
        if (head == null)
            return head;

        ListNode copyHead = head;

        int len = 1;
        while (copyHead.next != null) {
            copyHead = copyHead.next;
            ++len;
        }

        copyHead.next = head;

        for (int i = len - k % len; i > 1; --i)
            head = head.next;

        copyHead = head.next;
        head.next = null;

        return copyHead;
    }
}