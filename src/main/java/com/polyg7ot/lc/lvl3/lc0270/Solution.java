/**
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 */
package com.polyg7ot.lc.lvl3.lc0270;

import com.polyg7ot.data_structure.tree.TreeNode;

public class Solution {
    public int closestValue(TreeNode root, double target) {
        int val, closest = root.val;
        
        while(root != null){
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest; 
            root = target < root.val ? root.left : root.right;
        }
        
        return closest;
    }
}