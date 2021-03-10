/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl3.lc0129;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int sum) {
        if (node == null)
            return 0;

        int value = node.val;
        if (node.left == null && node.right == null) {
            return sum * 10 + value;
        }

        int left = dfs(node.left, sum * 10 + node.val);
        int right = dfs(node.right, sum * 10 + node.val);

        return left + right;
    }
}