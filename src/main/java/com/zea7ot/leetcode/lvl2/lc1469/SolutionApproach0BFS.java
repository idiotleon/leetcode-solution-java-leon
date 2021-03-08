/**
 * @author: Leon
 * https://leetcode.com/problems/find-all-the-lonely-nodes/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.zea7ot.leetcode.lvl2.lc1469;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                TreeNode cur = queue.poll();

                TreeNode left = cur.left;
                TreeNode right = cur.right;

                if (left != null && right != null) {
                    queue.offer(left);
                    queue.offer(right);
                } else {
                    if (left != null) {
                        ans.add(left.val);
                        queue.offer(left);
                    } else if (right != null) {
                        ans.add(right.val);
                        queue.offer(right);
                    }
                }
            }
        }

        return ans;
    }
}
