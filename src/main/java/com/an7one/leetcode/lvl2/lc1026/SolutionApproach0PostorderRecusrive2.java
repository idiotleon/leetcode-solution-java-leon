/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * a bottom-up approach
 */
package com.an7one.leetcode.lvl2.lc1026;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecusrive2 {
    public int maxAncestorDiff(TreeNode root) {
        int[] maxDiff = { 0 };
        postorder(root, maxDiff, root);
        return maxDiff[0];
    }

    private int[] postorder(TreeNode node, int[] maxDiff, TreeNode root) {
        if (node == null)
            return new int[] { root.val, root.val };

        int[] left = postorder(node.left, maxDiff, node);
        int[] right = postorder(node.right, maxDiff, node);

        int min = Math.min(left[0], right[0]);
        int max = Math.max(left[1], right[1]);
        int val = node.val;

        maxDiff[0] = Math.max(maxDiff[0], Math.max(Math.abs(val - min), Math.abs(val - max)));

        return new int[] { Math.min(min, val), Math.max(val, max) };
    }
}
