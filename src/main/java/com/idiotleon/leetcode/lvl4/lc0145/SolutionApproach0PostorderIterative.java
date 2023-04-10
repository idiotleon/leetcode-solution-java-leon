package com.idiotleon.leetcode.lvl4.lc0145;

import java.util.*;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">LC0145</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization/608296">Leetcode</a>
 * <a href="https://youtu.be/xLQKdq0Ffjg">Youtube</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0PostorderIterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        final Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            pushLeft(cur, stack);

            cur = stack.peek();
            if (cur.right != null) { // if `cur` has the right node, to process right first
                cur = cur.right;
            } else {
                cur = stack.pop();
                ans.add(cur.val);

                while (!stack.isEmpty() && cur == stack.peek().right) { // after processing both left and right, to
                    // to process the root
                    cur = stack.pop();
                    ans.add(cur.val);
                }

                cur = null;
            }
        }

        return ans;
    }

    private void pushLeft(TreeNode node, final Deque<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
