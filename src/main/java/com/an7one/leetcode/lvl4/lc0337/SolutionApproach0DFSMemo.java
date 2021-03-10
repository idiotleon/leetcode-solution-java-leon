/**
 * https://leetcode.com/problems/house-robber-iii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/house-robber-iii/discuss/79330/step-by-step-tackling-of-the-problem
 */
package com.an7one.leetcode.lvl4.lc0337;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSMemo {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null)
            return new int[2];

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int[] res = new int[2];

        // `idx` being 0 means the max value not having this node robbed
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        // `idx` being 1 means the max value having this node robbed
        res[1] = node.val + left[0] + right[0];

        return res;
    }
}
