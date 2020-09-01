/**
 * https://leetcode.com/problems/path-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl2.lc0112;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }

    private boolean dfs(TreeNode node, int target) {
        if (node == null)
            return false;

        target -= node.val;

        // !!!cannot be added
        // if(target < 0)
        // return false;

        if (target == 0) {
            if (node.left == null && node.right == null)
                return true;
        }

        return dfs(node.left, target) || dfs(node.right, target);
    }
}