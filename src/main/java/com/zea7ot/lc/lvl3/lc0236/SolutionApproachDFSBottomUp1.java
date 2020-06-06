/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
package com.zea7ot.lc.lvl3.lc0236;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproachDFSBottomUp1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }
}