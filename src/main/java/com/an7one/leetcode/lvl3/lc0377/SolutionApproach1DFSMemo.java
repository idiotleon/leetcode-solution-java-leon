package com.an7one.leetcode.lvl3.lc0377;

import com.an7one.util.Constant;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/combination-sum-iv/">LC0377</a>
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1DFSMemo {
    public int combinationSum4(int[] nums, int target) {
        final int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return dfs(nums, target, memo);
    }

    private int dfs(final int[] nums, final int target, final int[] memo) {
        final int N = nums.length;

        if (target < 0)
            return 0;

        if (target == 0)
            return 1;

        if (memo[target] != -1)
            return memo[target];

        int count = 0;
        for (int num : nums) {
            count += dfs(nums, target - num, memo);
        }

        return memo[target] = count;
    }
}