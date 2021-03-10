/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl2.lc0094;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.tree.TreeNode;

@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0InorderIterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        Deque<TreeNode> stack = new ArrayDeque<>();
        pushLeft(root, stack);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            ans.add(top.val);
            pushLeft(top.right, stack);
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