package com.idiotleon.leetcode.lvl3.lc0144;

import java.util.ArrayList;
import java.util.List;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">LC0144</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1PreorderRecursively {
    public List<Integer> preorderTraversal(TreeNode root) {
        final List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        preorder(root, ans);

        return ans;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;

        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}