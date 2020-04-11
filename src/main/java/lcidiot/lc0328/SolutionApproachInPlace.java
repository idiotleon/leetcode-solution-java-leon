/**
 * https://leetcode.com/problems/odd-even-linked-list/
 */
package main.java.lcidiot.lc0328;

import main.java.lcidiot.utils.ListNode;

public class SolutionApproachInPlace {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode odd = head, even = head.next, evenHead = even;
        
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        
        return head;
    }
}