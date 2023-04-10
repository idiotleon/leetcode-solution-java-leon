/**
 * https://leetcode.com/problems/same-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.idiotleon.leetcode.lvl2.lc0100;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        boolean left = dfs(p.left, q.left);
        boolean right = dfs(p.right, q.right);

        if (p.val != q.val)
            return false;
        return left && right;
    }
}
