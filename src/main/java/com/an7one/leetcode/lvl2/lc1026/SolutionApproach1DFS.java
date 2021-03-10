/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl2.lc1026;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach1DFS {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode node, int max, int min) {
        if (node == null)
            return max - min;

        max = Math.max(max, node.val);
        min = Math.min(min, node.val);

        return Math.max(dfs(node.left, max, min), dfs(node.right, max, min));
    }
}