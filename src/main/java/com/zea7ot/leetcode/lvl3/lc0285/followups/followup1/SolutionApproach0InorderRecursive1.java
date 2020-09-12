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

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0InorderRecursive1 {
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val >= p.val)
            return inorderPredecessor(root.left, p);
        else {
            TreeNode right = inorderPredecessor(root.right, p);
            return right == null ? root : right;
        }
    }
}