/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/sum-of-left-leaves/discuss/88950/Java-iterative-and-recursive-solutions
 */
package com.an7one.leetcode.lvl2.lc0404;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive3 {
    public int sumOfLeftLeaves(TreeNode root) {
        // sanity check
        if (root == null)
            return 0;

        int sum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null)
                sum += root.left.val;
            else
                sum += sumOfLeftLeaves(root.left);
        }

        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}