/**
 * https://leetcode.com/problems/path-sum/
 */
package main.java.lcidiot.lc0112;

import main.java.lcidiot.utils.TreeNode;

class SolutionApproachDFSTopDown {
    public boolean hasPathSumRecursion(TreeNode root, int sum) {
        if(root == null) return false;
        
        sum -= root.val;
        if(root.left == null && root.right == null)
            return sum == 0;
        
        return hasPathSumRecursion(root.left, sum) 
            || hasPathSumRecursion(root.right, sum);
    }
}