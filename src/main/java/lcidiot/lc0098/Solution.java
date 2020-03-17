/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
package main.java.lcidiot.lc0098;

import main.java.lcidiot.utils.TreeNode;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, 
                           Integer lower, 
                           Integer upper){
        if(root == null) return true;
        
        int val = root.val;
        if(lower != null && lower >= val) return false;
        if(upper != null && upper <= val) return false;
        
        if(!helper(root.left, lower, val)) return false;
        if(!helper(root.right, val, upper)) return false;
        
        return true;
    }
}