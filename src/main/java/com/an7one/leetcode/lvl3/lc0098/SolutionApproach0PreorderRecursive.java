/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl3.lc0098;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null)
            return true;

        int val = node.val;
        if (lower != null && lower >= val)
            return false;
        if (upper != null && upper <= val)
            return false;

        return isValidBST(node.left, lower, val) && isValidBST(node.right, val, upper);
    }
}