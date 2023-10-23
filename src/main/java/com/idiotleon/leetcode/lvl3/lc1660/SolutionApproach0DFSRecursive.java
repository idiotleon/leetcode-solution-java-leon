package com.idiotleon.leetcode.lvl3.lc1660;

import java.util.HashSet;
import java.util.Set;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/correct-a-binary-tree/">LC1660</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/correct-a-binary-tree/discuss/940769/Java-HashSet.-One-Pass.-Short">LCDiscussion</a>.
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive {
    public TreeNode correctBinaryTree(TreeNode root) {
        final Set<Integer> seen = new HashSet<>();

        return dfs(root, seen);
    }

    private TreeNode dfs(final TreeNode node, final Set<Integer> seen) {
        if (node == null) {
            return null;
        }
        if (node.right != null && seen.contains(node.right.val)) {
            return null;
        }
        seen.add(node.val);
        node.right = dfs(node.right, seen);
        node.left = dfs(node.left, seen);
        return node;
    }
}
