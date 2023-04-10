package com.idiotleon.leetcode.lvl2.lc0102;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">LC0102</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS0 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> paths = new ArrayList<>();
        // sanity check
        if (root == null)
            return paths;

        final Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final int sizeQ = queue.size();
            final List<Integer> path = new ArrayList<>();

            for (int i = 0; i < sizeQ; ++i) {
                final TreeNode cur = queue.removeFirst();
                path.add(cur.val);

                if (cur.left != null)
                    queue.addLast(cur.left);

                if (cur.right != null)
                    queue.addLast(cur.right);
            }

            paths.add(path);
        }

        return paths;
    }
}