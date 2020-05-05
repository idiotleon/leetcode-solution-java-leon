/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * 
 * Not allowed to use class member variable
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
package com.polyg7ot.lc.lvl3.lc0543.followup;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproahDFSBottomup {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        dfs(root, ans);
        return ans[0];
    }
    
    private int dfs(TreeNode node, int[] max){
        if(node == null) return 0;
        
        int left = dfs(node.left, max);
        int right = dfs(node.right, max);
        
        max[0] = Math.max(max[0], left + right);
        
        return Math.max(left, right) + 1;
    }
}