/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
package com.zea7ot.lc.lvl5.lc0099;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproachInorderRecoverByValue1 {
    private TreeNode firstElement, secondElement, prevElement;
    
    public void recoverTree(TreeNode root) {
        this.firstElement = null;
        this.secondElement = null;
        this.prevElement = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        
        // cheating: swap by value
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    
    private void inorder(TreeNode node){
        if(node == null) return;
        
        inorder(node.left);
        
        if(firstElement == null && prevElement.val > node.val){
            firstElement = prevElement;
        }
        
        if(firstElement != null && prevElement.val > node.val){
            secondElement = node;
        }
        prevElement = node;
        
        inorder(node.right);
    }
}