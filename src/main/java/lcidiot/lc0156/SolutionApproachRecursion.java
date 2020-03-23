/**
 * https://leetcode.com/problems/binary-tree-upside-down/
 */
package main.java.lcidiot.lc0156;

import main.java.lcidiot.utils.TreeNode;

class SolutionApproachRecursion {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return root;
        
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        
        root.left.left = root.right;
        root.left.right = root;
        
        root.left = null;
        root.right = null;
        
        return newRoot;
    }

    public TreeNode upsideDownBinaryTree2(TreeNode root) {
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