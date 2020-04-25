/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
package com.null7ptr.lc.lvl3.lc0572;

import com.null7ptr.data_structure.tree.TreeNode;

public class SolutionApproachDFS {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        return dfs(s, t);
    }
    
    private boolean dfs(TreeNode s, TreeNode t){
        if(s == null) return false;
        return sameTree(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }
    
    private boolean sameTree(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        
        return s.val == t.val 
            && sameTree(s.left, t.left) 
            && sameTree(s.right, t.right);
    }
}