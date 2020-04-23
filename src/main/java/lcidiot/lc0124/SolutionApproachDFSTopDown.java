/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775/Accepted-short-solution-in-Java
 * 
 * Top Down
 */
package main.java.lcidiot.lc0124;

import main.java.lcidiot.data_structure.tree.TreeNode;

class SolutionApproachDFSTopDown {
    private int maxValue;
    
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    private int maxPathDown(TreeNode node){
        if(node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}