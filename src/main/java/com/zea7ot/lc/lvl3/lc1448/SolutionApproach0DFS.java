/**
 * @author: Leon
 * 
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.lc.lvl3.lc1448;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFS {
    public int goodNodes(TreeNode root) {
        // sanity check
        if(root == null) return 0;

        return dfs(root, root.val);
    }
    
    private int dfs(TreeNode node, int curMax){
        if(node == null) return 0;
        
        int count = 0;
        if(node.val >= curMax) {
            count = 1;
            curMax = node.val;
        }
        
        return dfs(node.left, curMax) + dfs(node.right, curMax) + count;
    }
}