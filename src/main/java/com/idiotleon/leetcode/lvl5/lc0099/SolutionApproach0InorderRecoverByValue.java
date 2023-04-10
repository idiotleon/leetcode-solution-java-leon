/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.idiotleon.leetcode.lvl5.lc0099;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0InorderRecoverByValue {
    private TreeNode first, second, prev;

    public void recoverTree(TreeNode root) {
        // sanity check
        if (root == null)
            return;

        this.first = null;
        this.second = null;
        this.prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node) {
        if (node == null)
            return;

        inorder(node.left);

        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }

            second = node;
        }

        prev = node;

        inorder(node.right);
    }
}