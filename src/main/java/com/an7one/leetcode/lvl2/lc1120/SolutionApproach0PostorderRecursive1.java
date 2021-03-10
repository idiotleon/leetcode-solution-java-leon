/**
 * https://leetcode.com/problems/maximum-average-subtree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-average-subtree/discuss/334192/Java-8-line-clean-recursive-code-w-brief-comment-and-analysis.
 */
package com.an7one.leetcode.lvl2.lc1120;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive1 {
    public double maximumAverageSubtree(TreeNode root) {
        return dfs(root)[2];
    }

    private double[] dfs(TreeNode node) {
        if (node == null)
            return new double[] { 0, 0, 0 };

        double[] left = dfs(node.left);
        double[] right = dfs(node.right);

        double childAve = Math.max(left[2], right[2]);
        double sum = node.val + left[0] + right[0];
        double count = 1 + left[1] + right[1];
        double maxAveOfThree = Math.max(childAve, sum / count);
        return new double[] { sum, count, maxAveOfThree };
    }
}
