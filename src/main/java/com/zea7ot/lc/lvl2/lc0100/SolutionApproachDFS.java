/**
 * https://leetcode.com/problems/same-tree/
 */
package com.zea7ot.lc.lvl2.lc0100;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproachDFS {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
        return false;
    }
}