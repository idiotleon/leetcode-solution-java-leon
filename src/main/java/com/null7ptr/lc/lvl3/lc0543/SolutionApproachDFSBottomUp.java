/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(h). Recursion consumes stack space.
 */
package com.null7ptr.lc.lvl3.lc0543;

import com.null7ptr.data_structure.tree.TreeNode;

public class SolutionApproachDFSBottomUp {
    private int max;
    
    public int diameterOfBinaryTree(TreeNode root) {
        this.max = 0;
        dfs(root);
        return max;
    }
    
    private int dfs(TreeNode node){
        if(node == null) return 0;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
}