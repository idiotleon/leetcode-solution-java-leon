/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * Time Complexity:     O(LEN_A + LEN_B)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl2.lc0160;

import com.an7one.util.data_structure.linkedlist.ListNode;

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