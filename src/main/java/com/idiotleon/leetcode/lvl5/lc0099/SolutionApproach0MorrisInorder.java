/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/recover-binary-search-tree/discuss/32559/Detail-Explain-about-How-Morris-Traversal-Finds-two-Incorrect-Pointer
 */
package com.idiotleon.leetcode.lvl5.lc0099;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0MorrisInorder {
    public void recoverTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode first = null, second = null;

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                if (prev != null && prev.val > cur.val) {
                    if (first == null)
                        first = prev;
                    second = cur;
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
                    if (prev != null && prev.val > cur.val) {
                        if (first == null)
                            first = prev;
                        second = cur;
                    }
                    prev = cur;
                    cur = cur.right;
                }
            }
        }

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
