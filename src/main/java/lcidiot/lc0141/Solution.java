/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
package main.java.lcidiot.lc0141;

import main.java.lcidiot.utils.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
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