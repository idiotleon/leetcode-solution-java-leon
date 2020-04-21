/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
package main.java.lcidiot.lc0104;

import main.java.lcidiot.data_structure.tree.TreeNode;

class SolutionApproachDFSBottomUp {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}