/**
 * https://leetcode.com/problems/split-linked-list-in-parts/
 */
package com.an7one.leetcode.lvl3.lc0725;

import com.an7one.util.data_structure.linkedlist.ListNode;

public class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] parts = new ListNode[k];
        int len = 0;
        
        ListNode cur = root;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        
        int n = len / k, r = len % k;
        // to reset the pointer
        cur = root;
        // to break the list later on
        ListNode prev = null;
        
        for(int i = 0; cur != null && i < k; i++, r--){
            parts[i] = cur;
            
            for(int j = 0; j < n + (r > 0 ? 1 : 0); j++){
                prev = cur;
                cur = cur.next;
            }
            
            // to break the list
            prev.next = null;
        }
        
        return parts;
    }
}