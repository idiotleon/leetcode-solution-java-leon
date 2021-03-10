/**
 * https://leetcode.com/problems/same-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl2.lc0100;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return preorder(p, q);
    }

    private boolean preorder(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        return preorder(p.left, q.left) && preorder(p.right, q.right);
    }
}