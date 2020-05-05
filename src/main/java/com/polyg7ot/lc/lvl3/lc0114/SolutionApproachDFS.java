/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
package com.polyg7ot.lc.lvl3.lc0114;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproachDFS {
    private TreeNode prev = null;
    
    public void flatten(TreeNode root) {
        // sanity check
        if(root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        
        prev = root;
    }
}