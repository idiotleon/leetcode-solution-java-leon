/**
 * https://leetcode.com/problems/inorder-successor-in-bst/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0285;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0MorrisInorder {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode prev = null;
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                if (prev == p) {
                    return cur;
                }
                prev = cur;
                cur = cur.right;
            } else {
                TreeNode predecessor = cur.left;
                while (predecessor.right != cur && predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = cur;
                    cur = cur.left;
                } else {
                    predecessor.right = null;
                    if (prev == p) {
                        return cur;
                    }
                    prev = cur;
                    cur = cur.right;
                }
            }
        }

        return null;
    }
}
