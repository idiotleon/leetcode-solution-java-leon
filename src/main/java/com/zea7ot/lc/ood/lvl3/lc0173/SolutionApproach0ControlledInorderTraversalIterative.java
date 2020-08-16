/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * 
 * Time Complexities:
 *  construction:   O(H)
 *  hasNext():      O(1)
 *  next():         O(H)
 * 
 * Space Complexity: O(H)
 */
package com.zea7ot.lc.ood.lvl3.lc0173;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0ControlledInorderTraversalIterative {
    private final Deque<TreeNode> stack;

    public SolutionApproach0ControlledInorderTraversalIterative(TreeNode root) {
        this.stack = new ArrayDeque<TreeNode>();
        pushLeft(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = stack.pop();
        pushLeft(top.right);

        return top.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}