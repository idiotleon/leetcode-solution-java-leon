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
 *  https://leetcode.com/problems/subtree-of-another-tree/discuss/102724/Java-Solution-tree-traversal/153500
 *  https://leetcode.com/problems/subtree-of-another-tree/discuss/102724/Java-Solution-tree-traversal
 */
package com.an7one.leetcode.lvl3.lc0572;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
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
