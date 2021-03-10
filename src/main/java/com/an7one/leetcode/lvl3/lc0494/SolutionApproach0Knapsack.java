/**
 * https://leetcode.com/problems/target-sum/
 * 
 * Time Complexity:     O(N * RANGE)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation
 *  https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation/239358
 */
package com.an7one.leetcode.lvl3.lc0494;

public class SolutionApproach0Knapsack {
    public int findTargetSumWays(int[] nums, int S) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int sum = 0;
        for (int num : nums)
            sum += num;
        // sanity check
        if (S > sum || S < -sum)
            return 0;

        final int RANGE = 2 * sum + 1;

        int[] dp = new int[RANGE];
        dp[0 + sum] = 1;
        for (int i = 0; i < N; ++i) {
            int[] next = new int[RANGE];
            for (int k = 0; k < RANGE; ++k) {
                if (dp[k] == 0)
                    continue;
                next[k + nums[i]] += dp[k];
                next[k - nums[i]] += dp[k];
            }

            dp = next;
        }

        return dp[sum + S];
    }
}