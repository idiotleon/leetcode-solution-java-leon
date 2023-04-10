package com.idiotleon.leetcode.lvl4.lc0298;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/">LC0298</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Preorder1 {
    public int longestConsecutive(TreeNode root) {
        // sanity check
        if (root == null) return 0;

        return Math.max(dfs(root.left, 1, root.val + 1), dfs(root.right, 1, root.val + 1));
    }

    private int dfs(TreeNode node, int len, int expected) {
        if (node == null) return len;

        len = (node.val == expected) ? len + 1 : 1;
        int left = dfs(node.left, len, node.val + 1);
        int right = dfs(node.right, len, node.val + 1);

        return Math.max(len, Math.max(left, right));
    }
}