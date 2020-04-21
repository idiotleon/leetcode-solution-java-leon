/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
package main.java.lcidiot.lc0206;

import main.java.lcidiot.data_structure.linkedlist.ListNode;

class SolutionApproachRecursion {
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