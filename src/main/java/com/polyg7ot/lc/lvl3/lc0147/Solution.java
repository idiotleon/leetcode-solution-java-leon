/**
 * https://leetcode.com/problems/insertion-sort-list/
 */
package com.polyg7ot.lc.lvl3.lc0147;

import com.polyg7ot.data_structure.linkedlist.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        
        ListNode dummy = new ListNode(-1), prev = dummy;
        
        while(head != null){
            ListNode next = head.next;
            
            // to reset prev[ListNode]
            if(prev.val >= head.val) prev = dummy;
            
            // to find the right place to insert
            while(prev.next != null && prev.next.val < head.val)
                prev = prev.next;
            
            // to insert the new node, between prev and prev.next
            head.next = prev.next;
            prev.next = head;
            head = next;
        }
        
        return dummy.next;
    }
}