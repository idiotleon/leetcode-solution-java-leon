package com.idiotleon.leetcode.lvl3.lc0494;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/target-sum/">LC0494</a>
 * <p>
 * Time Complexity:     O(`N` * `sum`)
 * Space Complexity:    O(`N` * `sum`)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/target-sum/discuss/97333/Java-simple-DFS-with-memorization/356995">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSMemo {
    public int findTargetSumWays(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0) {
            return 0;
        }
        final int N = nums.length;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // sanity check
        if (target > sum || target < -sum) {
            return 0;
        }

        final Integer[][] memo = new Integer[N + 1][sum * 2 + 1];
        return dfs(0, sum, target + sum, nums, memo);
    }

    private int dfs(final int idx, final int sum, final int target, final int[] nums, final Integer[][] memo) {
        final int N = nums.length;
        if (idx == N) {
            return sum == target ? 1 : 0;
        }

        if (memo[idx][sum] != null) {
            return memo[idx][sum];
        }

        int res = dfs(idx + 1, sum + nums[idx], target, nums, memo) + dfs(idx + 1, sum - nums[idx], target, nums, memo);

        return memo[idx][sum] = res;
    }
}