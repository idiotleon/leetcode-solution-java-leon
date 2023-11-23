package com.idiotleon.leetcode.lvl3.lc0494;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/target-sum/">LC0494</a>
 * <p>
 * Time Complexity:     O(`N` ^ 2)
 * Space Complexity:    O(`N` ^ 2)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation/101899">LCDiscussion</a>
 * <a href="https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation/239358">LCDiscussion</a>
 * <a href="https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation/220467">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Knapsack1 {
    public int findTargetSumWays(final int[] nums, final int target) {
        // sanity check
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sumTotal = 0;
        for (int num : nums) {
            sumTotal += num;
        }

        // sanity check
        if (target < -sumTotal || target > sumTotal) {
            return 0;
        }

        final int RANGE = sumTotal * 2 + 1;

        final int L = nums.length;
        final int[][] dp = new int[L + 1][RANGE];
        dp[0][sumTotal] = 1;

        for (int idx = 1; idx <= L; ++idx) {
            for (int sum = 0; sum < RANGE; ++sum) {
                if (sum + nums[idx - 1] < RANGE) {
                    dp[idx][sum] += dp[idx - 1][sum + nums[idx - 1]];
                }

                if (sum - nums[idx - 1] >= 0) {
                    dp[idx][sum] += dp[idx - 1][sum - nums[idx - 1]];
                }
            }
        }

        return dp[L][sumTotal + target];
    }
}