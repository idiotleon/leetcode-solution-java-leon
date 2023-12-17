package com.idiotleon.leetcode.lvl3.lc0236;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">LC0236</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * a bottom-up approach
 * <p>
 * Reference:
 * <a href="https://www.youtube.com/watch?v=13m9ZCB8gjw">Youtube</a>
 */
@SuppressWarnings({Constant.WARNING.UNUSED})
public class SolutionApproach0DFSRecursive1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return postorder(root, p, q);
    }

    public TreeNode postorder(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = postorder(root.left, p, q);
        TreeNode right = postorder(root.right, p, q);

        if (left != null && right != null) return root;

        return left == null ? right : left;
    }
}