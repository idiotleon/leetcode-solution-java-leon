/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * a top-down approach
 * 
 * References:
 *  https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775/Accepted-short-solution-in-Java
 */
package com.zea7ot.leetcode.lvl4.lc0124;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderTraversalRecursive {
    public int maxPathSum(TreeNode root) {
        // sanity check
        if (root == null)
            return 0;

        int[] max = { Integer.MIN_VALUE };
        postorder(root, max);
        return max[0];
    }

    private int postorder(TreeNode node, int[] max) {
        if (node == null)
            return 0;
        int left = Math.max(0, postorder(node.left, max));
        int right = Math.max(0, postorder(node.right, max));
        max[0] = Math.max(max[0], left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}