package com.an7one.leetcode.lvl4.lc0145;

import java.util.ArrayList;
import java.util.List;

import com.an7one.util.Constant;
import com.an7one.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">LC0145</a>
 * <p>
 * Time Complexity:     O(N)
 * <p>
 * Space Complexity:    O(N)
 * O(N), consumed by the auxilliary space of `reverse(TreeNode from, TreeNode to)`
 * <p>
 * References:
 * <a href="https://gist.github.com/kanrourou/f7f4d46b2285539cc717">Gist</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1MorrisPostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        TreeNode sentinel = new TreeNode(-1);
        sentinel.left = root;
        TreeNode cur = sentinel;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode predecessor = cur.left;
                while (predecessor.right != null && predecessor.right != cur)
                    predecessor = predecessor.right;

                if (predecessor.right == null) {
                    predecessor.right = cur;
                    cur = cur.left;
                } else {
                    collect(cur.left, predecessor, ans);
                    predecessor.right = null;
                    cur = cur.right;
                }
            }
        }

        return ans;
    }

    private void collect(TreeNode from, TreeNode to, final List<Integer> res) {
        reverse(from, to);
        TreeNode cur = to;
        while (cur != from) {
            res.add(cur.val);
            cur = cur.right;
        }
        res.add(from.val);
        reverse(to, from);
    }

    private void reverse(TreeNode from, TreeNode to) {
        TreeNode a = from, b = from.right;
        while (a != to) {
            TreeNode c = b.right;
            b.right = a;
            a = b;
            b = c;
        }
    }
}