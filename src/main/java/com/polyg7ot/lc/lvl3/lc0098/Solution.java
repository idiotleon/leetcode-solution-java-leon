/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
package com.polyg7ot.lc.lvl3.lc0098;

import com.polyg7ot.data_structure.tree.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode root, Integer lower, Integer upper){
        if(root == null) return true;
        
        int val = root.val;
        if(lower != null && lower >= val) return false;
        if(upper != null && upper <= val) return false;
        
        if(!isValidBST(root.left, lower, val)) return false;
        if(!isValidBST(root.right, val, upper)) return false;
        
        return true;
    }
}