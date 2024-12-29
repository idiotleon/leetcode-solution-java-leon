package com.idiotleon.leetcode.lvl4.lc0314;

import com.idiotleon.util.data_structure.tree.TreeNode;

import java.util.*;

import static com.idiotleon.util.Constant.WARNING.UNUSED;

/**
 * @author: Leon
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@SuppressWarnings(UNUSED)
public class Solution0BFS {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        final List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        final Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        final Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);

        final Deque<Integer> cols = new ArrayDeque<Integer>();
        cols.add(0);

        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final int col = cols.poll();

            map.putIfAbsent(col, new ArrayList<Integer>());
            map.get(col).add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }
}