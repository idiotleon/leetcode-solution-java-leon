/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization/608296
 *  https://youtu.be/xLQKdq0Ffjg
 */
package com.an7one.leetcode.lvl4.lc0145;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderIterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        // sanity check
        if (root == null)
            return ans;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            pushLeft(cur, stack);

            cur = stack.peek();
            if (cur.right != null) { // if `cur` has right, to process right first
                cur = cur.right;
            } else {
                cur = stack.pop();
                ans.add(cur.val);

                while (!stack.isEmpty() && cur == stack.peek().right) { // after processing both left and right, to
                                                                        // process the root
                    cur = stack.pop();
                    ans.add(cur.val);
                }

                cur = null;
            }
        }

        return ans;
    }

    private void pushLeft(TreeNode node, Deque<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
