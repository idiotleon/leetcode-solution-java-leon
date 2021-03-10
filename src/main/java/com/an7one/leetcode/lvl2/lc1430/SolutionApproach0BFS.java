/**
 * https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 * 
 * References:
 *  https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/discuss/604457/JavaPython-3-DFS-and-BFS-clean-codes-w-brief-comments-explanation-and-analysis.
 */
package com.an7one.leetcode.lvl2.lc1430;

import java.util.ArrayDeque;
import java.util.Deque;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public boolean isValidSequence(TreeNode root, int[] nums) {
        if (root == null || nums == null || root.val != nums[0])
            return false;

        final int N = nums.length;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int level = 0;
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                TreeNode cur = queue.poll();
                if (cur.val != nums[level])
                    continue;

                if (level + 1 == N && isLeaf(cur))
                    return true;

                if (cur.left != null)
                    queue.offer(cur.left);

                if (cur.right != null)
                    queue.offer(cur.right);
            }

            if (++level == N)
                break;
        }

        return false;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;

        return node.left == null && node.right == null;
    }
}
