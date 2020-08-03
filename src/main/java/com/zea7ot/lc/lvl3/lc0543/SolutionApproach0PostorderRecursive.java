/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * a bottom up approach
 */
package com.zea7ot.lc.lvl3.lc0543;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = {0};
        postorder(root, max);
        return max[0];
    }

    private int postorder(TreeNode node, int[] max) {
        if (node == null)
            return 0;

        int left = postorder(node.left, max);
        int right = postorder(node.right, max);

        max[0] = Math.max(max[0], left + right);

        return Math.max(left, right) + 1;
    }
}