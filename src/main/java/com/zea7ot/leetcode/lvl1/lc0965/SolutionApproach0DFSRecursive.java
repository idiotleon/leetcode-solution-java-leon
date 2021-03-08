/**
 * @author: Leon
 * https://leetcode.com/problems/univalued-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl1.lc0965;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, null);
    }

    private boolean dfs(TreeNode node, Integer prev) {
        if (node == null)
            return true;

        if (prev != null && prev != node.val)
            return false;
        prev = node.val;

        boolean left = dfs(node.left, prev);
        boolean right = dfs(node.right, prev);

        return left && right;
    }
}
