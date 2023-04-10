package com.idiotleon.leetcode.lvl3.lc0515;

import java.util.*;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/find-largest-value-in-each-tree-row/">LC0515</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproachBFS {
    public List<Integer> largestValues(TreeNode root) {
        final List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        final Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        int max;
        while (!queue.isEmpty()) {
            final int size = queue.size();
            max = Integer.MIN_VALUE;

            for (int i = 0; i < size; ++i) {
                final TreeNode cur = queue.removeFirst();
                max = Math.max(max, cur.val);

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }

            ans.add(max);
        }

        return ans;
    }
}