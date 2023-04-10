/**
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 * 
 * Time Complexity:     O(2 * N) ~ O(N)
 * Space Complexity:    O(H)
 * 
 * to fire two rounds of (almost the same) postorder traversals:
 *  1st to get the total sum of all the tree nodes
 *  2nd to find the max product based on the traversal and the "sum"
 * 
 * References:
 *  https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/discuss/496496/Java-Two-Pass-PostOrder-Traversal
 *  https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/discuss/496549/JavaC%2B%2BPython-Easy-and-Concise
 */
package com.idiotleon.leetcode.lvl3.lc1339;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    private static final int MOD = (int) (1e9 + 7);

    public int maxProduct(TreeNode root) {
        long sum = getSum(root);
        long[] maxProd = { 0L };
        checkMax(root, maxProd, sum);
        return (int) ((maxProd[0]) % MOD);
    }

    private long checkMax(TreeNode node, long[] maxProd, long sum) {
        if (node == null)
            return 0;
        long left = checkMax(node.left, maxProd, sum);
        long right = checkMax(node.right, maxProd, sum);
        long curSum = left + right + node.val;
        maxProd[0] = Math.max(maxProd[0], curSum * (sum - curSum));
        return curSum;
    }

    private long getSum(TreeNode node) {
        if (node == null)
            return 0L;
        long left = getSum(node.left);
        long right = getSum(node.right);
        return left + right + node.val;
    }
}