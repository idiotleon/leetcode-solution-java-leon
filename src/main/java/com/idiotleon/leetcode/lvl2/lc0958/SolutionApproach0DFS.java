package com.idiotleon.leetcode.lvl2.lc0958;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * References:
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/discuss/205682/JavaC++Python-BFS-Level-Order-Traversal/209403
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFS {
    public boolean isCompleteTree(TreeNode root) {
        int total = countNodes(root);
        return dfs(root, 1, total);
    }

    private int countNodes(TreeNode node) {
        if (node == null)
            return 0;

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    private boolean dfs(TreeNode node, int idx, int total) {
        if (node == null)
            return true;
        if (idx > total)
            return false;

        return dfs(node.left, idx * 2, total) && dfs(node.right, idx * 2 + 1, total);
    }
}