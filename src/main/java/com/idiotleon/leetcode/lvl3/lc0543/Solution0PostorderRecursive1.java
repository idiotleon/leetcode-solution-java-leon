package com.idiotleon.leetcode.lvl3.lc0543;

import com.idiotleon.util.data_structure.tree.TreeNode;

import static com.idiotleon.util.Constant.WARNING.UNUSED;

/**
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/">lc0521</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * a bottom-up approach
 */
@SuppressWarnings(UNUSED)
public class Solution0PostorderRecursive1 {
    private int longest;

    public int diameterOfBinaryTree(TreeNode root) {
        this.longest = 0;
        postorder(root);
        return longest;
    }

    private int postorder(TreeNode node) {
        if (node == null) return 0;

        int left = postorder(node.left);
        int right = postorder(node.right);

        longest = Math.max(longest, left + right);

        return Math.max(left, right) + 1;
    }
}