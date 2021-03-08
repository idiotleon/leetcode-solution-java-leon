/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl3.lc0235;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        int val = root.val;
        if (val > p.val && val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (val < p.val && val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else
            return root;
    }
}