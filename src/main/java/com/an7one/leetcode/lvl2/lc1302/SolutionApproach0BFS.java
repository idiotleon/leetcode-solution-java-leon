/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 *  W, the maximum width of the tree
 * 
 * References:
 *  https://leetcode.com/problems/deepest-leaves-sum/discuss/463506/Java-Multiple-Solutions-%3A-BFS-%2B-DFS
 */
package com.an7one.leetcode.lvl2.lc1302;

import java.util.ArrayDeque;
import java.util.Deque;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public int deepestLeavesSum(TreeNode root) {
        // sanity check
        if (root == null)
            return 0;

        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();
            // to ONLY acquire the sum at the last level
            sum = 0;
            for (int i = 0; i < SIZE; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;

                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
        }

        return sum;
    }
}