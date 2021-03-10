/**
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.summary.tree.traversal.inorder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.an7one.util.data_structure.tree.TreeNode;

public class InorderTraversalterative1 {
    public List<Integer> inorderTraverse(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (root == null)
            return ans;

        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }

        return ans;
    }
}