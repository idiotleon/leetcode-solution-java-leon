/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.zea7ot.leetcode.lvl2.lc0102;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> PATHS = new ArrayList<>();
        // sanity check
        if (root == null)
            return PATHS;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();
            final List<Integer> PATH = new ArrayList<>();

            for (int i = 0; i < SIZE; ++i) {
                TreeNode cur = queue.poll();
                PATH.add(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }

                PATHS.add(PATH);
            }
        }

        return PATHS;
    }
}