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
 *  https://leetcode.com/problems/subtree-of-another-tree/discuss/102724/Java-Solution-tree-traversal/247276
 *  https://leetcode.com/problems/subtree-of-another-tree/discuss/102724/Java-Solution-tree-traversal
 */
package com.an7one.leetcode.lvl3.lc0572;

import java.util.ArrayDeque;
import java.util.Deque;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderIterative {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // sanity check
        if (s == null)
            return false;

        Deque<TreeNode> stack = new ArrayDeque<>();
        while (s != null || !stack.isEmpty()) {
            while (s != null) {
                stack.push(s);
                s = s.left;
            }

            s = stack.pop();
            if (isSameTree(s, t))
                return true;
            s = s.right;
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
