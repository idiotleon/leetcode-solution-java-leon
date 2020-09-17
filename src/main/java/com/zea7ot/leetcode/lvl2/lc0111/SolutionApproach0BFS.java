/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.zea7ot.leetcode.lvl2.lc0111;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public int minDepth(TreeNode root) {
        // sanity check
        if (root == null)
            return 0;

        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int height = 1;

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null)
                    return height;

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