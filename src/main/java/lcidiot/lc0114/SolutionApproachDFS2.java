/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
package main.java.lcidiot.lc0114;

import main.java.lcidiot.data_structure.tree.TreeNode;

public class SolutionApproachDFS2 {
    public void flatten3(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode node){
        if(node == null) return null;
        if(node.left == null && node.right == null) return node;
        
        TreeNode leftTail = helper(node.left);
        TreeNode rightTail = helper(node.right);
        
        if(leftTail != null){
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        return rightTail == null ? leftTail : rightTail;
    }
}