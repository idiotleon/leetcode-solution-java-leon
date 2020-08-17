/**
 * https://leetcode.com/problems/inorder-successor-in-bst/
 * 
 * Time Complexity:     O(H)
 * 
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/inorder-successor-in-bst/discuss/72653/Share-my-Java-recursive-solution
 *  https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 */
package com.zea7ot.leetcode.lvl3.lc0285;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Recursion {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        
        if(root.val <= p.val) return inorderSuccessor(root.right, p);
        else{
            TreeNode left = inorderSuccessor(root.left, p);
            return (left == null) ? root : left;
        }
    }
}