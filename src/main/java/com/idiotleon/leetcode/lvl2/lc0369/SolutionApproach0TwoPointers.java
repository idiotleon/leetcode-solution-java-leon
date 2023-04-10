/**
 * https://leetcode.com/problems/plus-one-linked-list/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/plus-one-linked-list/discuss/84125/Iterative-Two-Pointers-with-dummy-node-Java-O(n)-time-O(1)-space/88542
 */
package com.idiotleon.leetcode.lvl2.lc0369;

import com.idiotleon.util.data_structure.linkedlist.ListNode;

public class SolutionApproach0TwoPointers {
    public ListNode plusOne(ListNode head) {
        ListNode padding = new ListNode(0), lastNot9 = padding;
        padding.next = head;
        ListNode cur = head;
        while(cur != null){
            if(cur.val != 9) lastNot9 = cur;
            cur = cur.next;
        }
        ++lastNot9.val;
        
        cur = lastNot9.next;
        while(cur != null){
            cur.val = 0;
            cur = cur.next;
        }
        
        return padding.val == 1 ? padding : head;
    }
}