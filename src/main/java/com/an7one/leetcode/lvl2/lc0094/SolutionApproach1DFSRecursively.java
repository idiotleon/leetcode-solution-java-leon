package com.an7one.leetcode.lvl2.lc0094;

import java.util.ArrayList;
import java.util.List;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">LC0094</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1DFSRecursively {
    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        inorderTraverse(root, ans);
        return ans;
    }

    private void inorderTraverse(final TreeNode node, final List<Integer> res) {
        if (node == null)
            return;

        inorderTraverse(node.left, res);
        res.add(node.val);
        inorderTraverse(node.right, res);
    }
}