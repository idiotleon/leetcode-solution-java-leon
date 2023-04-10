/**
 * https://leetcode.com/problems/maximum-average-subtree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-average-subtree/discuss/334192/Java-8-line-clean-recursive-code-w-brief-comment-and-analysis.
 */
package com.idiotleon.leetcode.lvl2.lc1120;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    public double maximumAverageSubtree(TreeNode root) {
        return postorder(root).AVERAGE;
    }

    private Result postorder(TreeNode node) {
        if (node == null)
            return new Result(0, 0, 0D);

        Result left = postorder(node.left);
        Result right = postorder(node.right);

        int sum = node.val + left.SUM + right.SUM;
        int count = 1 + left.COUNT + right.COUNT;
        double average = (sum * 1.0) / count;
        // the max average among the parent and two children tree nodes
        double maxAverage = Math.max(average, Math.max(left.AVERAGE, right.AVERAGE));
        return new Result(sum, count, maxAverage);
    }

    private class Result {
        private final int SUM;
        private final int COUNT;
        private final double AVERAGE;

        private Result(final int SUM, final int COUNT, final double AVERAGE) {
            this.SUM = SUM;
            this.COUNT = COUNT;
            this.AVERAGE = AVERAGE;
        }
    }
}
