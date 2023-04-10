/**
 * @author: Leon
 * https://leetcode.com/problems/find-all-the-lonely-nodes/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.idiotleon.leetcode.lvl2.lc1469;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderIterative {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        Deque<TreeNode> stack = new ArrayDeque<>();
        pushLeft(root, stack, ans);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();

            if (top.right != null) {
                pushLeft(top.right, stack, ans);
            }
        }

        return ans;
    }

    private void pushLeft(TreeNode node, Deque<TreeNode> stack, List<Integer> res) {
        while (node != null) {
            TreeNode left = node.left;
            TreeNode right = node.right;

            if (left != null && right == null) {
                res.add(left.val);
            } else if (left == null && right != null) {
                res.add(right.val);
            }

            stack.push(node);
            node = node.left;
        }
    }
}
