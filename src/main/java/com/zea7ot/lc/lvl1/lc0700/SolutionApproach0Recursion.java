/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 */
package com.zea7ot.lc.lvl1.lc0700;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Recursion {
    public TreeNode searchBST(TreeNode root, int val) {
        return dfs(root, val);
    }
    
    private TreeNode dfs(TreeNode node, int val){
        if(node == null) return null;
        if(node.val > val) return dfs(node.left, val);
        if(node.val < val) return dfs(node.right, val);
        return node;
    }
}