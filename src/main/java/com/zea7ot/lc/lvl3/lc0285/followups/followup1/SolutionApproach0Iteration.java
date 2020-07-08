/**
 * to find out the inorder predecessor in a BST
 * 
 * 
 * References:
 *  https://leetcode.com/problems/inorder-successor-in-bst/discuss/72662/*Java*-5ms-short-code-with-explanations/75125
 */
package com.zea7ot.lc.lvl3.lc0285.followups.followup1;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Iteration {
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p){
        TreeNode prev = null;
        while(root != null){
            if(root.val < p.val){
                prev = root;
                root = root.right;
            }else root = root.left;
        }

        return prev;
    }
}