/**
 * https://leetcode.com/problems/combination-sum-iv/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation
 */
package com.an7one.leetcode.lvl3.lc0377;

import java.util.Arrays;

public class SolutionApproach1DFSMemo {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return dfs(nums, target, memo);
    }

    private int dfs(int[] nums, int target, int[] memo) {
        final int N = nums.length;

        if (target < 0)
            return 0;

        if (target == 0)
            return 1;

        if (memo[target] != -1)
            return memo[target];

        int count = 0;
        for (int i = 0; i < N; ++i) {
            count += dfs(nums, target - nums[i], memo);
        }

        return memo[target] = count;
    }
}