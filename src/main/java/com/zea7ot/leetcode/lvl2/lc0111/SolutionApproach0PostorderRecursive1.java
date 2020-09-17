/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl2.lc0111;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive1 {
    public int minDepth(TreeNode root) {
        return postorder(root);
    }

    private int postorder(TreeNode node) {
        if (node == null)
            return 0;

        if (node.left == null)
            return minDepth(node.right) + 1;

        if (node.right == null)
            return minDepth(node.left) + 1;

        return Math.min(minDepth(node.left), minDepth(node.right)) + 1;
    }
}