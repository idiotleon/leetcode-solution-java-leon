/**
 * https://leetcode.com/problems/path-sum-iii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method
 */
package com.zea7ot.leetcode.lvl3.lc0437;

import java.util.HashMap;
import java.util.Map;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFSWithPrefixSums {
    public int pathSum(TreeNode root, int sum) {
        // sanity check
        if (root == null)
            return 0;

        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);
        return dfs(0, sum, root, prefixSums);
    }

    private int dfs(int curSum, int target, TreeNode node, Map<Integer, Integer> prefixSums) {
        if (node == null)
            return 0;

        curSum += node.val;
        int res = prefixSums.getOrDefault(curSum - target, 0);
        prefixSums.put(curSum, prefixSums.getOrDefault(curSum, 0) + 1);

        res += dfs(curSum, target, node.left, prefixSums) + dfs(curSum, target, node.right, prefixSums);
        prefixSums.put(curSum, prefixSums.get(curSum) - 1);
        return res;
    }
}