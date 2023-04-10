package com.idiotleon.leetcode.lvl4.lc0145;

import java.util.ArrayList;
import java.util.List;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">LC0145</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1DFSRecursive {
    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        postorder(root, ans);
        return ans;
    }

    private void postorder(TreeNode node, List<Integer> ans) {
        if (node == null)
            return;

        postorder(node.left, ans);
        postorder(node.right, ans);
        ans.add(node.val);
    }
}