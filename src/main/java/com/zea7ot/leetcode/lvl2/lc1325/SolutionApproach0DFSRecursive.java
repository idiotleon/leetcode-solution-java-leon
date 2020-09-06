/**
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/delete-leaves-with-a-given-value/discuss/484264/JavaC%2B%2BPython-Recursion-Solution
 */
package com.zea7ot.leetcode.lvl2.lc1325;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root, target);
    }

    private TreeNode dfs(TreeNode node, final int TARGET) {
        if (node == null)
            return null;

        node.left = dfs(node.left, TARGET);
        node.right = dfs(node.right, TARGET);
        return isLeaf(node) && node.val == TARGET ? null : node;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;

        return node.left == null && node.right == null;
    }
}
