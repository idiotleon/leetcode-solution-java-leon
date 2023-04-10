package com.idiotleon.leetcode.lvl2.lc0814;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/binary-tree-pruning/">LC0814</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/binary-tree-pruning/discuss/122730/C++JavaPython-Self-Explaining-Solution-and-2-lines/247755">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0PostorderRecursive1 {
    public TreeNode pruneTree(final TreeNode root) {
        if (root == null) return null;
        if (postorder(root) == 0) return null;
        return root;
    }

    private int postorder(final TreeNode node) {
        if (node == null) return 0;

        final int left = postorder(node.left);
        final int right = postorder(node.right);
        node.left = left == 0 ? null : node.left;
        node.right = right == 0 ? null : node.right;
        return left + right + node.val;
    }
}