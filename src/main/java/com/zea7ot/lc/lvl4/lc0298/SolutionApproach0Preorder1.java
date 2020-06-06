/**
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.lc.lvl4.lc0298;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproach0Preorder1 {
    public int longestConsecutive(TreeNode root) {
        // sanity check
        if(root == null) return 0;
        
        return Math.max(dfs(root.left, 1, root.val + 1), dfs(root.right, 1, root.val + 1));
    }
    
    private int dfs(TreeNode node, int sequence, int target){
        if(node == null) return sequence;
        
        sequence = (node.val == target) ? sequence + 1 : 1;
        int left = dfs(node.left, sequence, node.val + 1);
        int right = dfs(node.right, sequence, node.val + 1);
        
        return Math.max(sequence, Math.max(left, right));
    }
}