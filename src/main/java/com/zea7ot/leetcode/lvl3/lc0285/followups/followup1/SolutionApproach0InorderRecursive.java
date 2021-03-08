/**
 * to find out the inorder predecessor in a BST
 * https://leetcode.com/discuss/interview-question/542842/facebook-phone-powx-n-inorder-predecessor-in-bst
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/inorder-successor-in-bst/discuss/72653/Share-my-Java-recursive-solution
 *  https://leetcode.com/discuss/interview-question/542842/Facebook-or-Phone-or-pow(x-n)-and-Inorder-Predecessor-in-BST/476126
 */
package com.zea7ot.leetcode.lvl3.lc0285.followups.followup1;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0InorderRecursive {
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        return inorder(root, p);
    }

    private TreeNode inorder(TreeNode node, TreeNode p) {
        if (node == null)
            return p;
        if (node.val >= p.val)
            return inorderPredecessor(node.left, p);
        else {
            TreeNode right = inorderPredecessor(node.right, p);
            return right == null ? node : right;
        }
    }
}