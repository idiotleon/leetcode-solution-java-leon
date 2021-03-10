/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.an7one.leetcode.lvl3.lc0114;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach1DFSRecursive {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        // sanity check
        if (node == null)
            return null;
        if (node.left == null && node.right == null)
            return node;

        TreeNode leftTail = dfs(node.left);
        TreeNode rightTail = dfs(node.right);

        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightTail == null ? leftTail : rightTail;
    }
}