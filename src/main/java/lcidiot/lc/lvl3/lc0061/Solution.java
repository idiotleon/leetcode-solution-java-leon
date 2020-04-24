/**
 * https://leetcode.com/problems/rotate-list/
 */
package main.java.lcidiot.lc.lvl3.lc0061;

import main.java.lcidiot.data_structure.linkedlist.ListNode;

public class Solution {
    /**
     * to link the tail of the list with the thead, making it a cycle
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        
        ListNode copyHead = head;
        
        int len = 1;
        while(copyHead.next != null){
            copyHead = copyHead.next;
            len++;
        }
        
        copyHead.next = head;
        
        for(int i = len - k % len; i > 1; i--){
            head = head.next;
        }
        
        copyHead = head.next;
        head.next = null;
        
        return copyHead;
    }
}