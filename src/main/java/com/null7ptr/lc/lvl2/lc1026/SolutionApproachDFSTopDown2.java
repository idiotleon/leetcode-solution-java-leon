/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor
 */
package com.null7ptr.lc.lvl2.lc1026;

import com.null7ptr.data_structure.tree.TreeNode;

public class SolutionApproachDFSTopDown2{
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
    
    private int dfs(TreeNode node, int max, int min){
        if(node == null) return max - min;
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        return Math.max(dfs(node.left, max, min), dfs(node.right, max, min));
    }
}