/**
 * @author: Leon
 * https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.idiotleon.leetcode.lvl2.lc1602;

import java.util.ArrayDeque;
import java.util.Deque;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root == u)
            return null;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                TreeNode cur = queue.poll();

                if (cur == u) {
                    if (i < SIZE - 1)
                        return queue.peek();
                    else
                        return null;
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

        return null;
    }
}
