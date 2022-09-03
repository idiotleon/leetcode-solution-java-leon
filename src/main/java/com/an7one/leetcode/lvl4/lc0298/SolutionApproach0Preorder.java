package com.an7one.leetcode.lvl4.lc0298;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/">LC0298</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Preorder {
    private int longest;

    public int longestConsecutive(TreeNode root) {
        // sanity check !cannot be omitted!
        if (root == null) return 0;
        this.longest = 0;
        preorder(root, 0, root.val + 1);
        return longest;
    }

    private void preorder(TreeNode node, int len, int target) {
        if (node == null) return;
        if (node.val == target) ++len;
        else len = 1;
        longest = Math.max(longest, len);
        preorder(node.left, len, node.val + 1);
        preorder(node.right, len, node.val + 1);
    }
}