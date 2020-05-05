/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
package com.polyg7ot.lc.lvl2.lc0206;

import com.polyg7ot.data_structure.linkedlist.ListNode;

public class SolutionApproachRecursion {
    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }
    
    private ListNode reverseList(ListNode head, ListNode newHead){
        if(head == null){
            return newHead;
        }
        
        ListNode next = head.next;
        head.next = newHead;
        return reverseList(next, head);
    }
}