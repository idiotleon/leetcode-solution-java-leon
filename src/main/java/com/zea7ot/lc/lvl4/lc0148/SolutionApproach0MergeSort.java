/**
 * https://leetcode.com/problems/sort-list/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(lg(N))
 */
package com.zea7ot.lc.lvl4.lc0148;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;

public class SolutionApproach0MergeSort {
    public ListNode sortList(ListNode head) {
        // sanity check
        if(head == null || head.next == null) return head;
        
        ListNode prev = null, slow = head, fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1), prev = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        
        prev.next = (l1 == null) ? l2 : l1;
        
        return dummy.next;
    }
}