/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
package com.polyg7ot.lc.lvl2.lc0206;

import com.polyg7ot.data_structure.linkedlist.ListNode;

public class SolutionApproachIteration {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
}