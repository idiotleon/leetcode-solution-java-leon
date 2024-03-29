/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 * 
 * References:
 *  https://leetcode.com/problems/sum-of-left-leaves/discuss/89060/Java-Solution-using-BFS
 */
package com.idiotleon.leetcode.lvl2.lc0404;

import java.util.ArrayDeque;
import java.util.Deque;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int sum = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                TreeNode node = queue.poll();

                if (isLeaf(node.left))
                    sum += node.left.val;

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }
        }

        return sum;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;
        return node.left == null && node.right == null;
    }
}