package com.idiotleon.leetcode.lvl3.lc0114;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * <p>
 * References:
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/37010/Share-my-simple-NON-recursive-solution-O(1)-space-complexity!/35136
 * https://www.youtube.com/watch?v=wGXB9OWhPTg
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/MorrisTraversal.java
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MorrisInorderTraversal {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode predecessor = cur.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                predecessor.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }

            cur = cur.right;
        }
    }
}