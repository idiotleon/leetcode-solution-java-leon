/**
 * https://leetcode.com/problems/house-robber-iii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/house-robber-iii/discuss/79330/step-by-step-tackling-of-the-problem
 */
package com.zea7ot.leetcode.lvl4.lc0337;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach1DFSNaive {
    public int rob(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int val = 0;

        if (node.left != null)
            val += dfs(node.left.left) + dfs(node.left.right);

        if (node.right != null)
            val += dfs(node.right.left) + dfs(node.right.right);

        return Math.max(val + node.val, dfs(node.left) + dfs(node.right));
    }
}
