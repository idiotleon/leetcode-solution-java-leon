package com.idiotleon.leetcode.lvl3.lc0513;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/find-bottom-left-tree-value/">LC0513</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproachPostOrder {
    private int deepest;
    private int leftmost;

    public int findBottomLeftValue(final TreeNode root) {
        deepest = 0;
        leftmost = root.val;

        postorder(root, 0);
        return leftmost;
    }

    private void postorder(final TreeNode node, final int depth) {
        if (node == null) return;

        postorder(node.left, depth + 1);
        postorder(node.right, depth + 1);
        if (depth > deepest) {
            deepest = depth;
            /* only to update the leftmost,
             * when it reaches the next level.
             * And only update once (per level),
             * because post order automatically starts with
             * the leftmost element in that level
             */
            leftmost = node.val;
        }
    }
}