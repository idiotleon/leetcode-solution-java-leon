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

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        int[] max = { Integer.MIN_VALUE };
        postorder(root, max);
        return max[0];
    }

    private int postorder(TreeNode node, int[] max) {
        if (node == null)
            return 0;

        int left = postorder(node.left, max);
        int right = postorder(node.right, max);
        max[0] = Math.max(max[0], left + right + node.val);
        return Math.max(0, Math.max(left, right) + node.val);
    }
}