/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl2.lc0104;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    public int maxDepth(TreeNode root) {
        // sanity check
        if (root == null)
            return 0;

        int[] deepest = { 1 };
        dfs(root, 1, deepest);
        return deepest[0];
    }

    private void dfs(TreeNode node, int curHeight, int[] deepest) {
        if (node == null)
            return;

        if (node.left != null) {
            ++curHeight;
            deepest[0] = Math.max(deepest[0], curHeight);
            dfs(node.left, curHeight, deepest);
            --curHeight;
        }

        if (node.right != null) {
            ++curHeight;
            deepest[0] = Math.max(deepest[0], curHeight);
            dfs(node.right, curHeight, deepest);
            --curHeight;
        }
    }
}