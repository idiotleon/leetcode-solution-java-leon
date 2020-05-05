/**
 * https://leetcode.com/problems/binary-tree-upside-down/
 */
package com.polyg7ot.lc.lvl3.lc0156;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproachDFSBottomUp {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // sanity check
        if(root == null || root.left == null && root.right == null) return root;
        
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        
        root.left.left = root.right;
        root.left.right = root;
        
        root.left = null;
        root.right = null;
        
        return newRoot;
    }
}