/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
package main.java.lcidiot.lc0082;

import main.java.lcidiot.utils.ListNode;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummyHead = new ListNode(-1), prev = dummyHead, cur = head;
        dummyHead.next = head;
        
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val)
                cur = cur.next;
            
            if(prev.next == cur) prev = prev.next;
            else prev.next = cur.next;
            
            cur = cur.next;
        }
        
        return dummyHead.next;
    }
}