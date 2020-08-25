/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl2.lc0404;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecurisve1 {
    public int sumOfLeftLeaves(TreeNode root) {
        // sanity check
        if (root == null)
            return 0;

        int[] sum = { 0 };
        dfs(root, sum);
        return sum[0];
    }

    private void dfs(TreeNode node, int[] sum) {
        if (node == null)
            return;

        if (node.left != null) {
            if (node.left.left == null && node.left.right == null)
                sum[0] += node.left.val;
            else
                dfs(node.left, sum);
        }

        dfs(node.right, sum);
    }
}