/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
package main.java.lcidiot.lc0129;

import main.java.lcidiot.utils.TreeNode;

class Solution {
    // solution i
    private int total;
    
    public int sumNumbers(TreeNode root) {
        total = 0;
        helper(root, 0);
        return total;
    }
    
    private void helper(TreeNode root, int sum){
        if(root == null) return;
        
        sum = sum * 10 + root.val;
        
        if(root.left == null && root.right == null){
            total += sum;
            return;
        }
        
        helper(root.left, sum);
        helper(root.right, sum);
    }

    // solution ii:
    public int sumNumbers2(TreeNode root) {
        return helper2(root, 0);
    }
    
    private int helper2(TreeNode node, int sum){
        if(node == null) return 0;
        if(node.right == null && node.left == null)
            return sum * 10 + node.val;
        
        return helper2(node.left, sum * 10 + node.val) 
            + helper2(node.right, sum * 10 + node.val);
    }
}