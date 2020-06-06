/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves
 * 
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/discuss/334577/JavaC%2B%2BPython-Two-Recursive-Solution
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */ 
package com.zea7ot.lc.lvl3.lc1123;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproachDFSBottomUp {
    private int deepest;
    private TreeNode lca;
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        this.deepest = 0;
        dfs(root, 0);
        return lca;
    }
    
    private int dfs(TreeNode node, int depth){
        deepest = Math.max(deepest, depth);
        if(node == null) return depth;
        
        int left = dfs(node.left, depth + 1);
        int right = dfs(node.right, depth + 1);
        
        if(left == deepest && right == deepest){
            lca = node;
        }
        
        return Math.max(left, right);
    }
}