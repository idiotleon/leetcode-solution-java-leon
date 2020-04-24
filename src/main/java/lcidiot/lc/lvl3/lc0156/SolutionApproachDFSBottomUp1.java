/**
 * https://leetcode.com/problems/binary-tree-upside-down/
 */
package main.java.lcidiot.lc.lvl3.lc0156;

import main.java.lcidiot.data_structure.tree.TreeNode;

public class SolutionApproachDFSBottomUp1 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // sanity check
        if(root == null) return null;
        if(root.left == null) return root;
        
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        TreeNode newLeft = upsideDownBinaryTree(root.right);
        
        root.left.left = newLeft;
        root.left.right = root;
        
        root.left = null;
        root.right = null;
        
        return newRoot;
    }
}