/**
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 */
package com.polyg7ot.lc.lvl4.lc0298;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproachDFSBottomUp {
    public int longestConsecutive(TreeNode root) {
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