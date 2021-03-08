/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * Time Complexity:     O(LEN_A + LEN_B)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0160;

import com.zea7ot.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0TwoPointers {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;

        while (curA != curB) {
            curA = (curA == null) ? headB : curA.next;
            curB = (curB == null) ? headA : curB.next;
        }

        return curA;
    }
}