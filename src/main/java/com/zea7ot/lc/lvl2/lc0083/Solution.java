/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
package com.zea7ot.lc.lvl2.lc0083;

import com.zea7ot.data_structure.linkedlist.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.next.val == cur.val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        
        return head;
    }
}