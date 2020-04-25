/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
package com.null7ptr.lc.lvl3.lc0114;

import com.null7ptr.data_structure.tree.TreeNode;

public class SolutionApproachDFS1 {
    public void flatten(TreeNode root) {
        dfs(root);
    }
    
    private TreeNode dfs(TreeNode node){
        // sanity check
        if(node == null) return null;
        if(node.left == null && node.right == null) return node;
        
        TreeNode leftTail = dfs(node.left);
        TreeNode rightTail = dfs(node.right);
        
        if(leftTail != null){
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        return rightTail == null ? leftTail : rightTail;
    }
}