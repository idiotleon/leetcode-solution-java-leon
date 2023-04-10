/**
 * @author: Leon
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl3.lc0098;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0MorrisInorder {
    public boolean isValidBST(TreeNode root) {
        TreeNode cur = root;

        Integer prev = null;

        while (cur != null) {
            if (cur.left == null) {
                if (prev != null && prev >= cur.val)
                    return false;
                prev = cur.val;
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
                    if (prev != null && prev >= cur.val)
                        return false;
                    prev = cur.val;
                    cur = cur.right;
                }
            }
        }

        return true;
    }
}
