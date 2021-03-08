/**
 * @author: Leon
 * 
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl3.lc1448;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFS1 {
    public int goodNodes(TreeNode root) {
        // sanity check
        if(root == null) return 0;
        
        int[] ans = {0};
        dfs(root, root.val, ans);
        return ans[0];
    }
    
    private void dfs(TreeNode node, int curMax, int[] ans){
        if(node == null) return;
        
        if(node.val >= curMax) {
            ans[0]++;
            curMax = node.val;
        }
        
        dfs(node.left, curMax, ans);
        dfs(node.right, curMax, ans);
    }
}