/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.an7one.leetcode.lvl2.lc0107;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        final LinkedList<List<Integer>> PATHS = new LinkedList<>();
        // sanity check
        if (root == null)
            return PATHS;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final List<Integer> PATH = new ArrayList<>();
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                TreeNode cur = queue.poll();

                PATH.add(cur.val);

                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }

            PATHS.addFirst(PATH);
        }

        return PATHS;
    }
}