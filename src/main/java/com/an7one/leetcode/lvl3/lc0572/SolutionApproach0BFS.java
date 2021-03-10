/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 * 
 * Time Complexity:     O(N_S * N_T)
 *  N_S, number of tree nodes of `s`
 *  N_T, number of tree nodes of `t`
 * 
 * Space Complexity:    O(H_S + H_T)
 *  H_S, height of tree `s`
 *  H_T, height of tree `t`
 * 
 * References:
 *  https://leetcode.com/problems/subtree-of-another-tree/discuss/102724/Java-Solution-tree-traversal/106046
 */
package com.an7one.leetcode.lvl3.lc0572;

import java.util.ArrayDeque;
import java.util.Deque;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // sanity check
        if (s == null)
            return false;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();
            for (int i = 0; i < SIZE; ++i) {
                TreeNode node = queue.poll();
                if (isSameTree(node, t))
                    return true;

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }
        }

        return false;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
