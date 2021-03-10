/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl3.lc0129;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    public int sumNumbers(TreeNode root) {
        int[] total = { 0 };
        preorder(root, 0, total);
        return total[0];
    }

    private void preorder(TreeNode root, int sum, int[] total) {
        if (root == null)
            return;

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            total[0] += sum;
            return;
        }

        preorder(root.left, sum, total);
        preorder(root.right, sum, total);
    }
}