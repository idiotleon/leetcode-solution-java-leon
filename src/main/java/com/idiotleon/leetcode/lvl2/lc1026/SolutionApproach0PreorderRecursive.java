/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * a top-down approach
 */
package com.idiotleon.leetcode.lvl2.lc1026;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {

    public int maxAncestorDiff(TreeNode root) {
        int[] maxDiff = { 0 };
        preorder(root, root.val, root.val, maxDiff);
        return maxDiff[0];
    }

    private void preorder(TreeNode node, int max, int min, int[] maxDiff) {
        if (node == null)
            return;

        max = Math.max(max, node.val);
        min = Math.min(min, node.val);

        maxDiff[0] = Math.max(maxDiff[0], max - min);

        preorder(node.left, max, min, maxDiff);
        preorder(node.right, max, min, maxDiff);
    }
}