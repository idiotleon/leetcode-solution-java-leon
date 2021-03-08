package com.zea7ot.leetcode.lvl2.lc1469;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderIterative1 {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                TreeNode left = cur.left;
                TreeNode right = cur.right;

                if (left != null && right == null) {
                    ans.add(left.val);
                } else if (left == null && right != null) {
                    ans.add(right.val);
                }

                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            cur = cur.right;
        }

        return ans;
    }
}
