/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.zea7ot.leetcode.lvl2.lc0104;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        // please be noted that height here should be initialized with 0, not 1
        // 1, or ++, should be performed when queue starts to poll
        int height = 0;

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                TreeNode cur = queue.poll();

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            ++height;
        }

        return height;
    }
}