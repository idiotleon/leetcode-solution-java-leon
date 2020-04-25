/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 
 * Java is strictly pass by value
 * https://www.geeksforgeeks.org/g-fact-31-java-is-strictly-pass-by-value/
 */
package com.null7ptr.lc.lvl3.lc0236;

import com.null7ptr.data_structure.tree.TreeNode;

public class SolutionApproachDFS1 {
    private TreeNode result;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int count = dfs(root, p, q);
        return result;
    }
    
    private int dfs(TreeNode root,
                    TreeNode p,
                    TreeNode q){
        int count = 0;
        if(root == null) return 0;
        if(root == p || root == q) count = 1;
        
        count += dfs(root.left, p, q);
        
        if(count < 2){
            count += dfs(root.right, p, q);
        }
        
        // to find the answer for the first time 2 nodes are found
        if(count == 2 && result == null) result = root;
        
        return count;
    }
}