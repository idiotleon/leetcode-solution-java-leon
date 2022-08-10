package com.an7one.leetcode.lvl3.lc0235;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">LC0235</a>
 * <p>
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;

        if (p.val > node.val && q.val > node.val)
            return dfs(node.right, p, q);
        else if (p.val < node.val && q.val < node.val)
            return dfs(node.left, p, q);
        return node;
    }
}