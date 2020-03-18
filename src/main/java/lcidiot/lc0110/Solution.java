/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */
package main.java.lcidiot.lc0110;

import main.java.lcidiot.utils.TreeNode;

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        return Math.abs(height(root.left) - height(root.right)) < 2
            && isBalanced(root.left)
            && isBalanced(root.right);
    }
    
    private int height(TreeNode root){
        if(root == null) return -1;
        
        return 1 + Math.max(height(root.left), height(root.right));
    }
}