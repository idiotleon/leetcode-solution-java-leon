/**
 * https://leetcode.com/problems/path-sum/
 */
package main.java.lcidiot.lc.lvl2.lc0112;

import main.java.lcidiot.data_structure.tree.TreeNode;

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