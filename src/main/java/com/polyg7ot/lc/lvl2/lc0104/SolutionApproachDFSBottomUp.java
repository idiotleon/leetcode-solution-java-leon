/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
package com.polyg7ot.lc.lvl2.lc0104;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproachDFSBottomUp {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}