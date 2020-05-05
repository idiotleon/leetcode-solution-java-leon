/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
package com.polyg7ot.lc.lvl4.lc0025;

import com.polyg7ot.data_structure.linkedlist.ListNode;

public class SolutionApproachIteration {
    public ListNode reverseKGroup(ListNode head, int k) {
        // sanity check
        if(k <= 1 || head == null || head.next == null) 
            return head;
        
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        
        ListNode prev, start, then, tail;
        tail = prev = newHead;
        start = prev.next;
        
        while(true){
            // to check if there is k nodes left-out
            for(int i = 0; i < k; i++){
                tail = tail.next;
                if(tail == null) 
                    return newHead.next;
            }
            
            // to reverse k nodes
            for(int i = 0; i < k - 1; i++){
                then = start.next;
                start.next = then.next;
                then.next = prev.next;
                prev.next = then;
            }
            tail = prev = start;
            start = prev.next;
        }
    }
}