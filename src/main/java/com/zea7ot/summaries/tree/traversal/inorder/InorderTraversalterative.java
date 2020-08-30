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

        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        pushLeft(stack, root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            ans.add(top.val);

            if (top.right != null)
                pushLeft(stack, top.right);
        }

        return ans;
    }

    /**
     * to push all the left nodes into the stack
     * 
     * @param stack
     * @param node
     */
    private void pushLeft(Deque<TreeNode> stack, TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}