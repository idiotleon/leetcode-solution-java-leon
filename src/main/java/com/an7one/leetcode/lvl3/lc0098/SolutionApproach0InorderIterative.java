/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
 */
package com.an7one.leetcode.lvl3.lc0098;

import java.util.ArrayDeque;
import java.util.Deque;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0InorderIterative {
    public boolean isValidBST(TreeNode root) {
        // sanity check
        if (root == null)
            return true;

        Integer prev = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        pushLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (prev != null && prev >= top.val)
                return false;
            prev = top.val;

            if (top.right != null) {
                pushLeft(top.right, stack);
            }
        }

        return true;
    }

    private void pushLeft(TreeNode node, Deque<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
