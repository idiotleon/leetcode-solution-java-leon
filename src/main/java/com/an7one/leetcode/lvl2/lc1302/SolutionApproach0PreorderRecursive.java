/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/deepest-leaves-sum/discuss/464774/Java-1ms-DFS-single-traversal-O(N)
 */
package com.an7one.leetcode.lvl2.lc1302;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    public int deepestLeavesSum(TreeNode root) {
        // sanity check
        if (root == null)
            return 0;

        int[] deepest = { 0 };
        int[] sum = { 0 };
        preorder(root, 0, deepest, sum);

        return sum[0];
    }

    private void preorder(TreeNode node, int depth, int[] deepest, int[] sum) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            if (depth == deepest[0]) {
                sum[0] += node.val;
            } else if (depth > deepest[0]) {
                sum[0] = node.val;
                deepest[0] = depth;
            }
            // curDepth < maxDepth[0]
            // else return;
        }

        preorder(node.left, depth + 1, deepest, sum);
        preorder(node.right, depth + 1, deepest, sum);
    }
}