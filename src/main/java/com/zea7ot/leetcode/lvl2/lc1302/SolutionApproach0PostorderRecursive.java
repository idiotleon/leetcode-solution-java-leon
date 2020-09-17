/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/deepest-leaves-sum/discuss/463178/Java-Short-and-Concise/418492
 */
package com.zea7ot.leetcode.lvl2.lc1302;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    public int deepestLeavesSum(TreeNode root) {
        // sanity check
        if (root == null)
            return 0;

        int[] deepest = { 0 };
        int[] sum = { 0 };
        postorder(root, 0, deepest, sum);

        return sum[0];
    }

    private void postorder(TreeNode node, int depth, int[] deepest, int[] sum) {
        if (node == null)
            return;

        postorder(node.left, depth + 1, deepest, sum);
        postorder(node.right, depth + 1, deepest, sum);

        if (node.left == null && node.right == null) {
            if (depth == deepest[0]) {
                sum[0] += node.val;
            } else if (depth > deepest[0]) {
                sum[0] = node.val;
                deepest[0] = depth;
            }
        }
    }
}