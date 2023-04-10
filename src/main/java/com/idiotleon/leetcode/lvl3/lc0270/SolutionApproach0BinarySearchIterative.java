/**
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl3.lc0270;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0BinarySearchIterative {
    public int closestValue(TreeNode root, double target) {
        int val, closest = root.val;

        while (root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root = target < root.val ? root.left : root.right;
        }

        return closest;
    }
}