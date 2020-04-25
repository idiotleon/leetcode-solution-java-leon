/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
package com.null7ptr.lc.lvl3.lc0141;

import com.null7ptr.data_structure.linkedlist.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        // sanity check
        if(head == null || head.next == null)
            return false;
        
        ListNode slow = head, fast = head.next;
        
        while(slow != fast){
            if(fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }
}