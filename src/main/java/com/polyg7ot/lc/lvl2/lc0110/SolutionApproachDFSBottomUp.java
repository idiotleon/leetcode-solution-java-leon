/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * 
 * Time Complexity: O(N)
 * https://leetcode.com/problems/balanced-binary-tree/discuss/35691/The-bottom-up-O(N)-solution-would-be-better
 */
package com.polyg7ot.lc.lvl2.lc0110;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproachDFSBottomUp {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    
    private int height(TreeNode root){
        if(root == null) return 0;
        
        int leftHeight = height(root.left);
        if(leftHeight == -1) return -1;
        
        int rightHeight = height(root.right);
        if(rightHeight == -1) return -1;
        
        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}