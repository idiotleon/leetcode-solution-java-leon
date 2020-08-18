/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * a bottom-up approach
 */
package com.zea7ot.leetcode.lvl3.lc0236;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return postorder(root, p, q);
    }

    private TreeNode postorder(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q)
            return node;

        TreeNode left = postorder(node.left, p, q);
        TreeNode right = postorder(node.right, p, q);

        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return node;
    }
}