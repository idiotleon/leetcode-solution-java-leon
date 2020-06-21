/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 
 * to use previously established next pointers
 */
package com.zea7ot.lc.lvl3.lc0116;

import com.zea7ot.utils.data_structure.tree.TreeNodeWithNextPtr;

public class Solution {
    public TreeNodeWithNextPtr connect(TreeNodeWithNextPtr root) {
        if(root == null) return root;
        
        TreeNodeWithNextPtr leftmost = root;
        
        while(leftmost.left != null){
            TreeNodeWithNextPtr head = leftmost;
            
            while(head != null){
                head.left.next = head.right;
                
                if(head.next != null) {
                    head.right.next = head.next.left;
                }
                
                head = head.next;
            }
            
            leftmost = leftmost.left;
        }
        
        return root;
    }
}