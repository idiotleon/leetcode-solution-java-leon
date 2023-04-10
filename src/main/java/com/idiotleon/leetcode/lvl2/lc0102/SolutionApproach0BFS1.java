package com.idiotleon.leetcode.lvl2.lc0102;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">LC0102</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        final Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        final List<Integer> intermediate = new ArrayList<>();

        while (!queue.isEmpty()) {
            intermediate.clear();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                final TreeNode cur = queue.poll();
                intermediate.add(cur.val);

                if (cur.left != null)
                    queue.add(cur.left);

                if (cur.right != null)
                    queue.add(cur.right);
            }
            ans.add(new ArrayList<>(intermediate));
        }

        return ans;
    }
}