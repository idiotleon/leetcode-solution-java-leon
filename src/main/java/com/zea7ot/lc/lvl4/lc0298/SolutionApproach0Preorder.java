/**
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.lc.lvl4.lc0298;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Preorder {
    private int max;
    
    public int longestConsecutive(TreeNode root) {
        // sanity check !cannot be omitted!
        if(root == null) return 0;
        this.max = 0;
        preorder(root, 0, root.val + 1);
        return max;
    }
    
    private void preorder(TreeNode node, int sequence, int target){
        if(node == null) return;
        if(node.val == target) sequence++;
        else sequence = 1;
        max = Math.max(max, sequence);
        preorder(node.left, sequence, node.val + 1);
        preorder(node.right, sequence, node.val + 1);
    }
}