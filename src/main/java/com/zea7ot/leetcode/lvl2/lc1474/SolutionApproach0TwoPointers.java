/**
 * https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/discuss/687977/Java-Easy-and-Concise
 */
package com.zea7ot.leetcode.lvl2.lc1474;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;

public class SolutionApproach0TwoPointers {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode cur = head, prev = null;
        while(cur != null){
            int i = m, j = n;
            
            while(cur != null && i-- > 0){
                prev = cur;
                cur = cur.next;
            }
            
            while(cur != null && j-- > 0){
                cur = cur.next;
            }
            
            prev.next = cur;
        }
        
        return head;
    }
}