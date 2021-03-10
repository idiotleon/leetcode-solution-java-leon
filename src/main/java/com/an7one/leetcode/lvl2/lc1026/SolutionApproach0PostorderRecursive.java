/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * a combination of top-down and bottom-up approach
 */
package com.an7one.leetcode.lvl2.lc1026;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int dfs(TreeNode node, int max, int min) {
        if (node == null)
            return 0;

        max = Math.max(max, node.val);
        min = Math.min(min, node.val);

        int left = dfs(node.left, max, min);
        int right = dfs(node.right, max, min);
        return Math.max(max - min, Math.max(left, right));
    }
}