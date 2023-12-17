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
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return postorder(root, p, q);
    }

    private TreeNode postorder(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q) {
            return node;
        }

        final TreeNode left = postorder(node.left, p, q);
        final TreeNode right = postorder(node.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return node;
        }
    }
}