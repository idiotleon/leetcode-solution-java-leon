/**
 * @author: Leon
 * https://leetcode.com/problems/even-odd-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.idiotleon.leetcode.lvl2.lc1609;

import java.util.ArrayDeque;
import java.util.Deque;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int level = 0;

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int sz = 0; sz < SIZE; ++sz) {
                TreeNode cur = queue.poll();
                int value = cur.val;

                if (level % 2 == 0) {
                    if (value % 2 == 0)
                        return false;

                    if (sz < SIZE - 1) {
                        if (value >= queue.peek().val)
                            return false;
                    }
                } else {
                    if (value % 2 == 1)
                        return false;

                    if (sz < SIZE - 1) {
                        if (value <= queue.peek().val)
                            return false;
                    }
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            ++level;
        }

        return true;
    }
}
