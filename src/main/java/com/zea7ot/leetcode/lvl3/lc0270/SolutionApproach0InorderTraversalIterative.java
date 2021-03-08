/**
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl3.lc0270;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0InorderTraversalIterative {
    public int closestValue(TreeNode root, double target) {
        // sanity check
        if (root == null)
            return 0;

        double closest = Double.MAX_VALUE;
        double prevVariance = Double.MAX_VALUE;
        int ans = root.val;

        Deque<TreeNode> stack = new ArrayDeque<>();
        pushLeft(stack, root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            double curVariance = Math.abs(target - top.val);
            if (curVariance < closest) {
                ans = top.val;
                closest = curVariance;
            }

            // pruning here
            if (prevVariance < curVariance)
                return ans;
            prevVariance = curVariance;

            if (top.right != null)
                pushLeft(stack, top.right);
        }

        return ans;
    }

    private void pushLeft(Deque<TreeNode> stack, TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}