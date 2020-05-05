/**
 * https://leetcode.com/problems/symmetric-tree/
 */
package com.polyg7ot.lc.lvl3.lc0101;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproachDFSTopDown {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }
    
    private boolean isSymmetric(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null) return false;
        
        return (n1.val == n2.val) 
            && isSymmetric(n1.left, n2.right) 
            && isSymmetric(n1.right, n2.left);
    }
}