/**
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl3.lc0270;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0InorderTravseralRecursive {
    public int closestValue(TreeNode root, double target) {
        if (root == null)
            return 0;

        Res res = new Res(Double.MAX_VALUE, root.val, Double.MAX_VALUE);
        inorder(root, target, res);

        return res.node;
    }

    private void inorder(TreeNode node, double target, Res res) {
        if (node == null)
            return;
        inorder(node.left, target, res);

        double curVariance = Math.abs(target - node.val);
        if (curVariance < res.closest) {
            res.closest = curVariance;
            res.node = node.val;
        } else
            res.prevVariance = curVariance;

        // pruning here
        if (curVariance > res.prevVariance)
            return;

        inorder(node.right, target, res);
    }

    private class Res {
        protected double closest;
        protected double prevVariance;
        protected int node;

        protected Res(double closest, int node, double prevVariance) {
            this.closest = closest;
            this.node = node;
            this.prevVariance = prevVariance;
        }
    }
}