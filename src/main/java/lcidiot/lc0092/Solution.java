/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
package main.java.lcidiot.lc0092;

import main.java.lcidiot.utils.ListNode;

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1), prev = dummy, cur = head;
        dummy.next = head;
        
        int idx = 1;
        while(idx < m){
            prev = cur;
            cur = cur.next;
            idx++;
        }
        
        ListNode node = prev;
        while(idx <= n){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            idx++;
        }
        
        node.next.next = cur;
        node.next = prev;
        
        return dummy.next;
    }
}