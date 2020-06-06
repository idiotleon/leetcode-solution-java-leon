/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
package com.zea7ot.lc.lvl4.lc0025;

import com.zea7ot.data_structure.linkedlist.ListNode;

public class SolutionApproachRecursion {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while(cur != null && count != k){
            cur = cur.next;
            count++;
        }
        
        if(count == k){
            cur = reverseKGroup(cur, k);
            
            while(count-- > 0){
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            
            head = cur;
        }

        return head;
    }
}