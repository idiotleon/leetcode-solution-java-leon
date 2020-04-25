/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 */
package com.null7ptr.lc.lvl2.lc1026;

import com.null7ptr.data_structure.tree.TreeNode;

public class SolutionApproachDFSTopDown {
    private int maxDiff;
    
    public int maxAncestorDiff(TreeNode root) {
        this.maxDiff = 0;
        dfs(root, root.val, root.val);
        return maxDiff;
    }
    
    private void dfs(TreeNode node, int max, int min){
        if(node == null) return;
        
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        
        maxDiff = Math.max(maxDiff, max - min);
        
        dfs(node.left, max, min);
        dfs(node.right, max, min);
    }
}