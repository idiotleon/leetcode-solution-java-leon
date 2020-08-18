/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0203;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // sanity check
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