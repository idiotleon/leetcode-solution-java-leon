/**
 * https://leetcode.com/problems/path-sum-iii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method
 */
package com.an7one.leetcode.lvl3.lc0437;

import java.util.HashMap;
import java.util.Map;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSWithPrefixSums {
    public int pathSum(TreeNode root, int sum) {
        // sanity check
        if (root == null)
            return 0;

        Map<Integer, Integer> prefixSumToFreq = new HashMap<>();
        prefixSumToFreq.put(0, 1);
        return backtrack(0, sum, root, prefixSumToFreq);
    }

    private int backtrack(int curSum, int target, TreeNode node, Map<Integer, Integer> prefixSumToFreq) {
        if (node == null)
            return 0;

        curSum += node.val;
        int res = prefixSumToFreq.getOrDefault(curSum - target, 0);

        prefixSumToFreq.put(curSum, prefixSumToFreq.getOrDefault(curSum, 0) + 1);
        res += backtrack(curSum, target, node.left, prefixSumToFreq) + backtrack(curSum, target, node.right, prefixSumToFreq);
        prefixSumToFreq.put(curSum, prefixSumToFreq.get(curSum) - 1);

        return res;
    }
}