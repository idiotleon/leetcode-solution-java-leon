/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 * 
 * 
 */
package com.idiotleon.leetcode.lvl2.lc0617;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0Recursion1 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;

        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode root = new TreeNode(val);

        root.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        root.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return root;
    }
}