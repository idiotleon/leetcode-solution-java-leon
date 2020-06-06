/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
package com.zea7ot.lc.lvl2.lc0111;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproachDFSBottomUp1 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}