/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
 * Time Complexity:     O(N)
 * Space Compleixty:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share
 *  https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share/146292
 */
package com.zea7ot.leetcode.lvl3.lc0114;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Postorder1 {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        // sanity check
        if (root == null)
            return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }
}