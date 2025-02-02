package com.idiotleon.leetcode.lvl3.lc0543;

import com.idiotleon.util.data_structure.tree.TreeNode;

import static com.idiotleon.util.Constant.WARNING.UNUSED;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/">lc0543</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * a bottom-up approach
 */
@SuppressWarnings(UNUSED)
public class Solution0PostorderRecursive {
    public int diameterOfBinaryTree(TreeNode root) {
        final int[] longest = {0};
        postorder(root, longest);
        return longest[0];
    }

    private int postorder(final TreeNode node, final int[] longest) {
        if (node == null) {
            return 0;
        }

        int left = postorder(node.left, longest);
        int right = postorder(node.right, longest);

        longest[0] = Math.max(longest[0], left + right);

        return Math.max(left, right) + 1;
    }
}