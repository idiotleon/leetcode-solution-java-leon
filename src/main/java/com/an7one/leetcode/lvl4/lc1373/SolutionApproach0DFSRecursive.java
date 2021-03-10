/**
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/discuss/534877/Java-One-pass-post-order-DFS-O(N)
 *  https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/discuss/531822/Java-Post-Order-Traverse-with-Comment-Clean-code
 */
package com.an7one.leetcode.lvl4.lc1373;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    public int maxSumBST(TreeNode root) {
        int[] maxSum = { 0 };
        postorder(root, maxSum);
        return maxSum[0];
    }

    private Result postorder(TreeNode node, int[] maxSum) {
        if (node == null)
            return new Result(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);

        Result left = postorder(node.left, maxSum);
        Result right = postorder(node.right, maxSum);

        final int VAL = node.val;
        final boolean IS_BST = left.IS_BST && right.IS_BST && VAL > left.MAX && VAL < right.MIN;

        final int SUM = VAL + left.SUM + right.SUM;

        if (IS_BST) {
            maxSum[0] = Math.max(maxSum[0], SUM);
        }

        final int MIN = Math.min(VAL, left.MIN);
        final int MAX = Math.max(VAL, right.MAX);

        return new Result(IS_BST, MAX, MIN, SUM);
    }

    private class Result {
        private final boolean IS_BST;
        private final int MAX;
        private final int MIN;
        private final int SUM;

        private Result(final boolean IS_BST, final int MAX, final int MIN, final int SUM) {
            this.IS_BST = IS_BST;
            this.MAX = MAX;
            this.MIN = MIN;
            this.SUM = SUM;
        }
    }
}
