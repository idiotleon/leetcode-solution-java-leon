package com.idiotleon.leetcode.lvl3.lc0103;

import java.util.*;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">LC0103</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        final List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (root == null) return ans;

        final Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int level = 0;

        while (!queue.isEmpty()) {
            final int sizeQ = queue.size();
            final List<Integer> intermediate = new ArrayList<>();

            for (int i = 0; i < sizeQ; ++i) {
                final TreeNode cur = queue.removeFirst();
                intermediate.add(cur.val);

                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            if (level % 2 != 0) {
                Collections.reverse(intermediate);
            }
            ++level;
            ans.add(new ArrayList<>(intermediate));
        }

        return ans;
    }
}