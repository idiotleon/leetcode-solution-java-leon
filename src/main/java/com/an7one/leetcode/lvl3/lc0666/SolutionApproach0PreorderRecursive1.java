/**
 * https://leetcode.com/problems/path-sum-iv/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/path-sum-iv/discuss/106892/Java-solution-Represent-tree-using-HashMap
 */
package com.an7one.leetcode.lvl3.lc0666;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0PreorderRecursive1 {
    private int sum;

    public int pathSum(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        this.sum = 0;
        Map<Integer, Integer> tree = new HashMap<Integer, Integer>();

        for (int num : nums) {
            int key = num / 10;
            int value = num % 10;
            tree.put(key, value);
        }

        preorder(nums[0] / 10, 0, tree);
        return sum;
    }

    private void preorder(int node, int prevSum, Map<Integer, Integer> tree) {
        int level = node / 10;
        int pos = node % 10;
        int left = (level + 1) * 10 + pos * 2 - 1;
        int right = (level + 1) * 10 + pos * 2;

        int curSum = prevSum + tree.get(node);

        if (!tree.containsKey(left) && !tree.containsKey(right)) {
            sum += curSum;
            return;
        }

        if (tree.containsKey(left))
            preorder(left, curSum, tree);
        if (tree.containsKey(right))
            preorder(right, curSum, tree);
    }
}