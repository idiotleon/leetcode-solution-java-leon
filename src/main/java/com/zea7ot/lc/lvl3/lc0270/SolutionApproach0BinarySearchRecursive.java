/**
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 */
package com.zea7ot.lc.lvl3.lc0270;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0BinarySearchRecursive {
    public int closestValue(TreeNode root, double target) {
        if (root == null)
            return 0;

        Res res = new Res(Double.MAX_VALUE, 0);
        inorder(root, target, res);

        return res.node;
    }

    private void inorder(TreeNode node, double target, Res res) {
        if (node == null)
            return;

        if (Math.abs(node.val - target) < res.variance) {
            res.variance = Math.abs(node.val - target);
            res.node = node.val;
        }

        if (node.val > target)
            inorder(node.left, target, res);
        else
            inorder(node.right, target, res);
    }

    private class Res {
        protected double variance;
        protected int node;

        protected Res(double variance, int node) {
            this.variance = variance;
            this.node = node;
        }
    }
}