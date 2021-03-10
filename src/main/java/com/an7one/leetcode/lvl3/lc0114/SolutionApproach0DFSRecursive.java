package com.an7one.leetcode.lvl3.lc0114;

import com.an7one.util.data_structure.tree.TreeNode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * References:
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share/35059
 */
public class SolutionApproach0DFSRecursive {
    public void flatten(TreeNode root) {
        flatten(root, null);
    }

    private TreeNode flatten(TreeNode node, TreeNode prev) {
        if (node == null)
            return prev;
        prev = flatten(node.right, prev);
        prev = flatten(node.left, prev);
        node.right = prev;
        node.left = null;
        prev = node;
        return prev;
    }
}