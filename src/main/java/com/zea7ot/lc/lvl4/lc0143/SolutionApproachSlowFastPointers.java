/**
 * https://leetcode.com/problems/reorder-list/
 */
package com.zea7ot.lc.lvl4.lc0143;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;

public class SolutionApproachSlowFastPointers {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        
        // step 1: to cut the list into two halves
        ListNode prev = null, slow = head, fast = head, l1 = head;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        // step 2: to reverse the 2nd half
        ListNode l2 = reverse(slow);

        // step 3: to merge the two halves
        merge(l1, l2);
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null, cur = head, next = null;
        
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
    
    private void merge(ListNode head1, ListNode head2){
        while(head2 != null){
            ListNode next = head1.next;
            head1.next = head2;
            head1 = head2;
            head2 = next;
        }
    }
}