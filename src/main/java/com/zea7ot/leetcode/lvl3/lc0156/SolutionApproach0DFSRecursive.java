/**
 * https://leetcode.com/problems/binary-tree-upside-down/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/binary-tree-upside-down/discuss/49412/Clean-Java-solution/49658
 *  https://leetcode.com/problems/binary-tree-upside-down/discuss/49412/Clean-Java-solution
 */
package com.zea7ot.leetcode.lvl3.lc0156;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return dfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null || isLeaf(node))
            return node;

        TreeNode newRoot = dfs(node.left);
        node.left.left = node.right;
        node.left.right = node;

        node.left = null;
        node.right = null;

        return newRoot;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;

        return node.left == null && node.right == null;
    }
}