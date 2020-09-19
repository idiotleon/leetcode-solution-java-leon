/**
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.summaries.tree.traversal.inorder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class InorderTraversalterative {
    public List<Integer> inorderTraverse(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (root == null)
            return ans;

        Deque<TreeNode> stack = new ArrayDeque<>();
        pushLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            ans.add(top.val);

            if (top.right != null) {
                pushLeft(top.right, stack);
            }
        }

        return ans;
    }

    /**
     * to push all the left nodes into the stack
     * 
     * @param stack
     * @param node
     */
    private void pushLeft(TreeNode node, Deque<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}