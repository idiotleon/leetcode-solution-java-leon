/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/36045/My-4-Line-java-solution/242269
 */
package com.an7one.leetcode.lvl2.lc0111;

import java.util.ArrayDeque;
import java.util.Deque;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public int minDepth(TreeNode root) {
        // sanity check
        if (root == null)
            return 0;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int height = 1;

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int sz = 0; sz < SIZE; ++sz) {
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