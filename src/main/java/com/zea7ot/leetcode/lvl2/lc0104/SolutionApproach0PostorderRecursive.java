/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl2.lc0104;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}