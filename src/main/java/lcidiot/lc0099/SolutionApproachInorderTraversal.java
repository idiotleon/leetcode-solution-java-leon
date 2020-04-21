/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
package main.java.lcidiot.lc0099;

import main.java.lcidiot.data_structure.tree.TreeNode;

public class SolutionApproachInorderTraversal {
    private TreeNode firstElement = null, secondElement = null;
    private TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        
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