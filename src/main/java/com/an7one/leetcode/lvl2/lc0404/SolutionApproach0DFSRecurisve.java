/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl2.lc0404;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecurisve {
    public int sumOfLeftLeaves(TreeNode root) {
        // sanity check
        if (root == null)
            return 0;

        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int sum = 0;
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null)
                sum += node.left.val;
            else
                sum += dfs(node.left);
        }

        sum += dfs(node.right);
        return sum;
    }
}