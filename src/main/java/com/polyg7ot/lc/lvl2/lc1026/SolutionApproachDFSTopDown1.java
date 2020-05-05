/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 */
package com.polyg7ot.lc.lvl2.lc1026;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproachDFSTopDown1 {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
    
    private int dfs(TreeNode node, int max, int min){
        if(node == null) return 0;
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        
        int left = dfs(node.left, max, min);
        int right = dfs(node.right, max, min);
        return Math.max(max - min, Math.max(left, right));
    }
}