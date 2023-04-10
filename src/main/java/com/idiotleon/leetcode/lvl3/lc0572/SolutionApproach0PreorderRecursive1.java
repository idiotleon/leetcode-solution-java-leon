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
 *  https://leetcode.com/problems/subtree-of-another-tree/discuss/102724/Java-Solution-tree-traversal
 */
package com.idiotleon.leetcode.lvl3.lc0572;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive1 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        return dfs(s, t);
    }

    private boolean dfs(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        return sameTree(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    private boolean sameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;

        return s.val == t.val && sameTree(s.left, t.left) && sameTree(s.right, t.right);
    }
}