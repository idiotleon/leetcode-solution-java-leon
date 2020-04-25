/**
 * https://leetcode.com/problems/longest-univalue-path/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.null7ptr.lc.lvl3.lc0687;

import com.null7ptr.data_structure.tree.TreeNode;

public class SolutionApproachDFS {
    private int longest;
    public int longestUnivaluePath(TreeNode root) {
        this.longest = 0;
        dfs(root);
        return longest;
    }
    
    private int dfs(TreeNode node){
        if(node == null) return 0;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        int pl = 0, pr = 0;
        if(node.left != null && node.val == node.left.val) pl = left + 1;
        if(node.right != null && node.val == node.right.val) pr = right + 1;
        
        this.longest = Math.max(this.longest, pl + pr);
        
        return Math.max(pl, pr);
    }
}