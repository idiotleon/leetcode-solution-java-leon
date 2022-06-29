package com.an7one.leetcode.lvl4.lc0145;

import java.util.*;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.tree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">0145</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * References:
 * To make sure that all children of a node are traversed
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization/44991">Leetcode</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1DFSIterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        final Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (!isLeaf(cur)) {
                stack.push(cur);
                cur = cur.left;
            }

            if (cur != null)
                ans.add(cur.val);

            while (!stack.isEmpty() && cur == stack.peek().right) {
                cur = stack.pop();
                ans.add(cur.val);
            }

            if (stack.isEmpty())
                cur = null;
            else
                cur = stack.peek().right;
        }

        return ans;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return true;
        return node.left == null && node.right == null;
    }
}