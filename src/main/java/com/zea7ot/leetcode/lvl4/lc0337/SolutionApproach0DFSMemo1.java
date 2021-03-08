/**
 * https://leetcode.com/problems/house-robber-iii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N) + O(H) ~ O(N)
 * 
 * References:
 *  https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/108730/javacstraightforward-dfs-solution
 */
package com.zea7ot.leetcode.lvl4.lc0337;

import java.util.HashMap;
import java.util.Map;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSMemo1 {
    public int rob(TreeNode root) {
        return dfs(root, new HashMap<>());
    }

    private int dfs(TreeNode node, final Map<TreeNode, Integer> MEMO) {
        if (node == null)
            return 0;
        if (MEMO.containsKey(node))
            return MEMO.get(node);

        int val = 0;
        if (node.left != null)
            val += dfs(node.left.left, MEMO) + dfs(node.left.right, MEMO);

        if (node.right != null)
            val += dfs(node.right.left, MEMO) + dfs(node.right.right, MEMO);

        val = Math.max(val + node.val, dfs(node.left, MEMO) + dfs(node.right, MEMO));
        MEMO.put(node, val);
        return val;
    }
}
