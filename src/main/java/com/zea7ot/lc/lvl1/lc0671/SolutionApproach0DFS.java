/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.lc.lvl1.lc0671;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFS {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        return findSecondMinimumValue(root, root.val);
    }
    
    private int findSecondMinimumValue(TreeNode node, int min){
        if(node == null) return -1;
        if(node.val > min) return node.val;
        int leftMin = findSecondMinimumValue(node.left, min);
        int rightMin = findSecondMinimumValue(node.right, min);
        return (leftMin == -1 || rightMin == -1) ? Math.max(leftMin, rightMin) : Math.min(leftMin, rightMin);
    }
}