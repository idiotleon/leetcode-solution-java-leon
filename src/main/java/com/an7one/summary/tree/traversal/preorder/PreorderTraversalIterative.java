/**
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.summary.tree.traversal.preorder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.an7one.util.data_structure.tree.TreeNode;

public class PreorderTraversalIterative {
    public List<Integer> preorderTraverse(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                ans.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            cur = cur.right;
        }

        return ans;
    }
}