/**
 * https://leetcode.com/problems/plus-one-linked-list/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(lg(L))
 * 
 * References:
 *  https://leetcode.com/problems/plus-one-linked-list/discuss/84130/Java-recursive-solution
 */
package com.zea7ot.lc.lvl2.lc0369;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;

public class SolutionApproach0DFS {
    public ListNode plusOne(ListNode head) {
        if(dfs(head) == 0) return head;
        else{
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
    }
    
    private int dfs(ListNode head){
        if(head == null) return 1;
        int carry = dfs(head.next);
        if(carry == 0) return 0;
        
        int val = head.val + 1;
        head.val = val % 10;
        return val / 10;
    }
}