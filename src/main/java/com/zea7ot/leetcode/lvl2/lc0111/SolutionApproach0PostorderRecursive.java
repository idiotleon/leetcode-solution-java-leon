/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl2.lc0111;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    public int minDepth(TreeNode root) {
        return postorder(root);
    }

    private int postorder(TreeNode node) {
        if (node == null)
            return 0;

        int left = postorder(node.left);
        int right = postorder(node.right);

        if (left == 0 || right == 0) {
            return Math.max(left, right) + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }
}
