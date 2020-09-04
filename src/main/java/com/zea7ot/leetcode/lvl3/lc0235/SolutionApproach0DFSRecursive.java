/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl3.lc0235;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;

        if (p.val > node.val && q.val > node.val)
            return dfs(node.right, p, q);
        else if (p.val < node.val && q.val < node.val)
            return dfs(node.left, p, q);
        return node;
    }
}