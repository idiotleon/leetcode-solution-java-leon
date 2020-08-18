/**
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl3.lc0270;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0InorderTraversalIterative1 {
    public int closestValue(TreeNode root, double target) {
        // sanity check
        if (root == null)
            return 0;

        double closest = Double.MAX_VALUE;
        double prevVariance = Double.MAX_VALUE;
        int ans = root.val;

        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            pushLeft(stack, cur);
            cur = stack.pop();

            double curVariance = Math.abs(target - cur.val);
            if (curVariance < closest) {
                ans = cur.val;
                closest = curVariance;
            }

            // pruning here
            if (prevVariance < curVariance)
                return ans;
            prevVariance = curVariance;

            cur = cur.right;
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