/**
 * https://leetcode.com/problems/house-robber-iii/
 */
package com.zea7ot.lc.lvl4.lc0337;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproachPostorder {
    public int rob(TreeNode root) {
        int[] ans = postorder(root);
        return Math.max(ans[0], ans[1]);
    }
    
    private int[] postorder(TreeNode node){
        if(node == null) return new int[2];
        int[] left = postorder(node.left);
        int[] right = postorder(node.right);
        int[] res = new int[2];
        // idx being 0 means the max value not having this node robbed
        // idx being 1 means the max value having this node robbed
        res[0] = left[1] + right[1] + node.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}