/**
 * https://leetcode.com/problems/same-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.zea7ot.leetcode.lvl2.lc0100;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                TreeNode first = queue.poll();
                TreeNode second = queue.poll();

                if (first == null && second == null)
                    continue;

                if (first == null || second == null || first.val != second.val)
                    return false;

                queue.add(first.left);
                queue.add(second.left);
                queue.add(first.right);
                queue.add(second.right);
            }
        }

        return true;
    }
}