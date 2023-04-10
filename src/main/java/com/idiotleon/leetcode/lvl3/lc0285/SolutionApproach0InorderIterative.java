/**
 * @author: Leon
 * https://leetcode.com/problems/inorder-successor-in-bst/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.idiotleon.leetcode.lvl3.lc0285;

import java.util.ArrayDeque;
import java.util.Deque;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0InorderIterative {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        pushLeft(root, stack);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            pushLeft(top.right, stack);
            if (top == p)
                return stack.peek();
        }

        return null;
    }

    private void pushLeft(TreeNode node, Deque<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
