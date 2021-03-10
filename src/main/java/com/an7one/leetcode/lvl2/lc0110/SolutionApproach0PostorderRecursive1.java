/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/balanced-binary-tree/discuss/35691/The-bottom-up-O(N)-solution-would-be-better
 */
package com.an7one.leetcode.lvl2.lc0110;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive1 {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = height(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}