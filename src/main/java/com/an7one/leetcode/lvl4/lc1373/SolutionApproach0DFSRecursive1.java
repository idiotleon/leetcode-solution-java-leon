/**
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/discuss/531822/Java-Post-Order-Traverse-with-Comment-Clean-code
 */
package com.an7one.leetcode.lvl4.lc1373;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive1 {
    public int maxSumBST(TreeNode root) {
        int[] maxSum = { 0 };
        postorder(root, maxSum);
        return maxSum[0];
    }

    private int[] postorder(TreeNode node, int[] maxSum) {
        if (node == null)
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };

        int[] left = postorder(node.left, maxSum);
        int[] right = postorder(node.right, maxSum);

        if (!(left != null && right != null && node.val > left[1] && node.val < right[0]))
            return null;

        int sum = node.val + left[2] + right[2];
        maxSum[0] = Math.max(maxSum[0], sum);

        int min = Math.min(node.val, left[0]);
        int max = Math.max(node.val, right[1]);
        return new int[] { min, max, sum };
    }
}
