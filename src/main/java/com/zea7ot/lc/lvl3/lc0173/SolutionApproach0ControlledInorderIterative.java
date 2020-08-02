/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * 
 * Time Complexities:
 *  hasNext()   O(1)
 *  next()      O(1)
 * 
 * Space Complexity: O(H)
 */
package com.zea7ot.lc.lvl3.lc0173;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0ControlledInorderIterative {
    private final Deque<TreeNode> stack;

    public SolutionApproach0ControlledInorderIterative(TreeNode root) {
        this.stack = new ArrayDeque<TreeNode>();
        this.pushLeft(root);
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = stack.pop();

        if (top.right != null)
            this.pushLeft(top.right);

        return top.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}