/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O()
 */
package com.an7one.leetcode.lvl3.lc0144;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderIterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            ans.add(top.val);

            if (top.right != null)
                stack.push(top.right);

            if (top.left != null)
                stack.push(top.left);
        }

        return ans;
    }
}