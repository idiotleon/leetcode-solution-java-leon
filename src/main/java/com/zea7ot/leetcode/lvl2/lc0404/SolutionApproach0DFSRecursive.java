/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/sum-of-left-leaves/discuss/88950/Java-iterative-and-recursive-solutions
 */
package com.zea7ot.leetcode.lvl2.lc0404;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null) ans += root.left.val;
            else ans += sumOfLeftLeaves(root.left);
        }
        
        ans += sumOfLeftLeaves(root.right);
        return ans;
    }
}