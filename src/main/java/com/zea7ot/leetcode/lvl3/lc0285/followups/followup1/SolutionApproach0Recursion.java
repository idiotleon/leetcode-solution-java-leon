/**
 * 
 * 
 * References:
 *  https://leetcode.com/problems/inorder-successor-in-bst/discuss/72653/Share-my-Java-recursive-solution
 */
package com.zea7ot.leetcode.lvl3.lc0285.followups.followup1;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Recursion {
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p){
        if(root == null) return null;

        if(root.val >= p.val) return inorderPredecessor(root.left, p);
        else{
            TreeNode right = inorderPredecessor(root.right, p);
            return right == null ? root : right;
        }
    }
}