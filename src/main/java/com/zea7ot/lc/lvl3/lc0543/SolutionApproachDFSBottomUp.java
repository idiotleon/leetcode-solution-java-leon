/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(H). Recursion consumes stack space.
 */
package com.zea7ot.lc.lvl3.lc0543;

import com.zea7ot.utils.data_structure.tree.TreeNode;

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