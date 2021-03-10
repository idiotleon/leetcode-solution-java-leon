/**
 * https://leetcode.com/problems/inorder-successor-in-bst/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/inorder-successor-in-bst/discuss/72653/Share-my-Java-recursive-solution
 *  https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 */
package com.an7one.leetcode.lvl3.lc0285;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0InorderRecursive {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inorder(root, p);
    }

    private TreeNode inorder(TreeNode node, TreeNode p) {
        if (node == null)
            return null;

        if (node.val <= p.val) {
            return inorder(node.right, p);
        } else {
            TreeNode left = inorder(node.left, p);
            return (left == null) ? node : left;
        }
    }
}