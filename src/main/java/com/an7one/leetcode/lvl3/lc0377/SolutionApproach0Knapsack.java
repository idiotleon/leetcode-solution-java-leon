package com.an7one.leetcode.lvl3.lc0377;

import com.an7one.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/combination-sum-iv/">LC0377</a>
 * <p>
 * Time Complexity:     O(`N` * `target`)
 * Space Complexity:    O(`target`)
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/combination-sum-iv/discuss/111860/Coin-change-AND-this-problem">LC Discussion</a>
 * <p>
 * Almost the same Problems:
 * <a href="https://leetcode.com/problems/coin-change-2/">LC0518</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Knapsack {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; ++i) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}