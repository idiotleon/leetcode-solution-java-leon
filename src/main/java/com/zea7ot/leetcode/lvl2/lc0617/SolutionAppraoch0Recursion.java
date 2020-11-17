/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 * 
 * Time Complexity:     O(N(t1) + N(t2)) ~ O(max(N(t1), N(t2)))
 * Space Complexity:    O(H(t1) + H(t2)) ~ O(max(H(t1), H(t2)))
 */
package com.zea7ot.leetcode.lvl2.lc0617;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionAppraoch0Recursion {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        TreeNode root = new TreeNode(t1.val + t2.val);

        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);

        return root;
    }
}