/**
 * @author: Leon
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H) + O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0098;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0InorderRecursive {
    public boolean isValidBST(TreeNode root) {
        // `Integer.MIN_VALUE` is not small enough
        Integer[] prev = { null };
        return inorder(root, prev);
    }

    private boolean inorder(TreeNode node, Integer[] prev) {
        if (node == null)
            return true;

        boolean left = inorder(node.left, prev);
        if (prev[0] != null && prev[0] >= node.val)
            return false;
        prev[0] = node.val;
        boolean right = inorder(node.right, prev);

        return left && right;
    }
}
