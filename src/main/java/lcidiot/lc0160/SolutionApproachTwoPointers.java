/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
package main.java.lcidiot.lc0160;

import main.java.lcidiot.utils.ListNode;

public class SolutionApproachTwoPointers {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        
        while(curA != curB){
            curA = (curA == null) ? headB : curA.next;
            curB = (curB == null) ? headA : curB.next;
        }
        
        return curA;
    }
}