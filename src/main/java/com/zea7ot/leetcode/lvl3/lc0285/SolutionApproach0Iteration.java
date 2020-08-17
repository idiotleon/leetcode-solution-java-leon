/**
 * https://leetcode.com/problems/inorder-successor-in-bst/
 * 
 * Time Complexity:     O(H)
 *  if a tree is balanced,  O(H) ~ O(lg(N))
 *  if a tree is skewed,    O(H) ~ O(N)
 * 
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/inorder-successor-in-bst/discuss/72656/JavaPython-solution-O(h)-time-and-O(1)-space-iterative
 *  https://leetcode.com/problems/inorder-successor-in-bst/discuss/72662/*Java*-5ms-short-code-with-explanations
 *  https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 */
package com.zea7ot.leetcode.lvl3.lc0285;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Iteration {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while(root != null){
            if(p.val < root.val){
                successor = root;
                root = root.left;
            }else root = root.right;
        }
        
        return successor;
    }
}