/**
 * https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/discuss/419618/Simple-Java-solution-using-DFS-for-slow-learners-like-myself
 */
package com.zea7ot.lc.lvl3.lc1080;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFS {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root, limit, 0);
    }
    
    private TreeNode dfs(TreeNode node, int limit, int sum){
        if(node == null) return null;
        
        sum += node.val;
        
        if(isLeaf(node)) return sum >= limit ? node : null;
        
        node.left = dfs(node.left, limit, sum);
        node.right = dfs(node.right, limit, sum);
        
        return isLeaf(node) ? null : node;
    }
    
    private boolean isLeaf(TreeNode node){
        if(node == null) return false;
        return node.left == null && node.right == null;
    }
}