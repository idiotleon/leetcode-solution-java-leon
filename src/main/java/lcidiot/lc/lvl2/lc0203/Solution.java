/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
package main.java.lcidiot.lc.lvl2.lc0203;

import main.java.lcidiot.data_structure.linkedlist.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        
        ListNode dummy = new ListNode(-1), prev = dummy;
        dummy.next = head;
        
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        
        return dummy.next;
    }
}