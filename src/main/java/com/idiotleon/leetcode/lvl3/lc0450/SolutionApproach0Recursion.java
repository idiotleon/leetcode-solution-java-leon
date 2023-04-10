/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/delete-node-in-a-bst/discuss/93296/Recursive-Easy-to-Understand-Java-Solution/97795
 */
package com.idiotleon.leetcode.lvl3.lc0450;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0Recursion {
    public TreeNode deleteNode(TreeNode root, int key) {
        // sanity check
        if (root == null)
            return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            TreeNode rightSmallest = root.right;
            while (rightSmallest.left != null) {
                rightSmallest = rightSmallest.left;
            }
            rightSmallest.left = root.left;
            return root.right;
        }

        return root;
    }
}