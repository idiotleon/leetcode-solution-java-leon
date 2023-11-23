package com.idiotleon.leetcode.lvl3.lc0494;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/target-sum/">LC0494</a>
 * <p>
 * Time Complexity:     O(`N` * `RANGE`)
 * Space Complexity:    O(`N`)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation">LCDiscussion</a>
 * <a href="https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation/239358">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Knapsack {
    public int findTargetSumWays(final int[] nums, final int target) {
        // sanity check
        if (nums == null || nums.length == 0) {
            return 0;
        }

        final int N = nums.length;
        int sumTotal = 0;
        for (int num : nums) {
            sumTotal += num;
        }

        // sanity check
        if (target > sumTotal || target < -sumTotal) {
            return 0;
        }

        final int RANGE = 2 * sumTotal + 1;

        int[] dp = new int[RANGE];
        dp[0 + sumTotal] = 1;
        for (final int num : nums) {
            final int[] next = new int[RANGE];
            for (int sum = 0; sum < RANGE; ++sum) {
                if (dp[sum] == 0) {
                    continue;
                }
                next[sum + num] += dp[sum];
                next[sum - num] += dp[sum];
            }

            dp = next;
        }

        return dp[sumTotal + target];
    }
}