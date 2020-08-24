/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 * 
 * References:
 *  https://leetcode.com/problems/sum-of-left-leaves/discuss/89060/Java-Solution-using-BFS
 */
package com.zea7ot.leetcode.lvl2.lc0404;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int sum = 0;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null && node.left.left == null && node.left.right == null)
                sum += node.left.val;

            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }

        return sum;
    }
}