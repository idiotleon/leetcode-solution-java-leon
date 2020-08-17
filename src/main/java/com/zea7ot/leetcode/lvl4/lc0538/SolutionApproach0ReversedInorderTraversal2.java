/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  
 */
package com.zea7ot.leetcode.lvl4.lc0538;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0ReversedInorderTraversal2 {
    private int prev = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root.right != null) convertBST(root.right);
        prev = root.val = prev + root.val;
        if(root.left != null) convertBST(root.left);
        return root;
    }
}