/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
package com.null7ptr.lc.lvl3.lc0236;

import com.null7ptr.data_structure.tree.TreeNode;

public class SolutionApproachDFSBottomUp1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null) return root;
        
        return left == null ? right : left;
    }
}