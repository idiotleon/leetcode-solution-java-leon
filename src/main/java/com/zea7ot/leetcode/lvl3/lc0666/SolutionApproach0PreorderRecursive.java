/**
 * https://leetcode.com/problems/path-sum-iv/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/path-sum-iv/discuss/106892/Java-solution-Represent-tree-using-HashMap
 */
package com.zea7ot.leetcode.lvl3.lc0666;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0PreorderRecursive {
    public int pathSum(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        Map<Integer, Integer> tree = new HashMap<Integer, Integer>();
        for (int num : nums) {
            int level = num / 10, val = num % 10;
            tree.put(level, val);
        }

        return preorder(0, nums[0] / 10, tree);
    }

    private int preorder(int prevSum, int node, Map<Integer, Integer> tree) {

        if (!tree.containsKey(node))
            return 0;
        int level = node / 10, pos = node % 10, val = tree.get(node);
        int left = (level + 1) * 10 + 2 * pos - 1;
        int right = (level + 1) * 10 + 2 * pos;

        int curSum = prevSum + val;
        if (!tree.containsKey(left) && !tree.containsKey(right))
            return curSum;
        return preorder(curSum, left, tree) + preorder(curSum, right, tree);
    }
}