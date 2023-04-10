/**
 * https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/discuss/419618/Simple-Java-solution-using-DFS-for-slow-learners-like-myself
 */
package com.idiotleon.leetcode.lvl3.lc1080;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root, 0, limit);
    }

    private TreeNode dfs(TreeNode node, int sum, final int LIMIT) {
        if (node == null)
            return null;

        sum += node.val;

        if (isLeaf(node))
            return sum >= LIMIT ? node : null;

        node.left = dfs(node.left, sum, LIMIT);
        node.right = dfs(node.right, sum, LIMIT);

        return isLeaf(node) ? null : node;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;

        return node.left == null && node.right == null;
    }
}