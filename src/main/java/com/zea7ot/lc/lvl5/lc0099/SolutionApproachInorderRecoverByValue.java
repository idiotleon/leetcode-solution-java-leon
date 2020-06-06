/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
package com.zea7ot.lc.lvl5.lc0099;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproachInorderRecoverByValue {
    private TreeNode first, second, prev;
    
    public void recoverTree(TreeNode root) {
        // sanity check
        if(root == null) return;
        
        this.first = null;
        this.second = null;
        this.prev = new TreeNode(Integer.MIN_VALUE);
        
        inorder(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode node){
        if(node == null) return;
        
        inorder(node.left);
        
        if(prev != null && prev.val > node.val){
            if(first == null){
                first = prev;
            }
            
            second = node;
        }
        
        prev = node;
        
        inorder(node.right);
    }
}