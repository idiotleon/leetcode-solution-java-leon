/**
 * https://leetcode.com/problems/path-sum/
 */
package com.zea7ot.lc.lvl2.lc0112;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproachDFSTopDown {
    public boolean hasPathSumRecursion(TreeNode root, int sum) {
        if(root == null) return false;
        
        sum -= root.val;
        if(root.left == null && root.right == null)
            return sum == 0;
        
        return hasPathSumRecursion(root.left, sum) 
            || hasPathSumRecursion(root.right, sum);
    }
}