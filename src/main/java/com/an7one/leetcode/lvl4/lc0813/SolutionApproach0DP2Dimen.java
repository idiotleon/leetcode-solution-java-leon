/**
 * https://leetcode.com/problems/largest-sum-of-averages/
 * 
 * Time Complexity:     O(N ^ 3)
 * Space Complexity:    O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/largest-sum-of-averages/discuss/126280/Naive-Detailed-Step-by-Step-Approach-from-Recursive-to-DP-O(N)-solution
 *  https://youtu.be/FLbqgyJ-70I?t=6087
 */
package com.an7one.leetcode.lvl4.lc0813;

public class SolutionApproach0DP2Dimen {
    public double largestSumOfAverages(int[] nums, int K) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0D;

        final int N = nums.length;
        final int[] PREFIX_SUMS = new int[N];
        for (int i = 0; i < N; ++i) {
            PREFIX_SUMS[i] = nums[i] + (i > 0 ? PREFIX_SUMS[i - 1] : 0);
        }

        double[][] dp = new double[N][K + 1];
        for (int k = 1; k <= K; ++k) {
            for (int i = 0; i + k <= N; ++i) {
                if (k == 1) {
                    dp[i][k] = ((double) (PREFIX_SUMS[N - 1] - PREFIX_SUMS[i] + nums[i])) / (N - i);
                } else {
                    for (int j = i; j + k <= N; ++j) {
                        dp[i][k] = Math.max(dp[i][k], (dp[j + 1][k - 1]
                                + ((double) (PREFIX_SUMS[j] - PREFIX_SUMS[i] + nums[i])) / (j - i + 1)));
                    }
                }
            }
        }

        return dp[0][K];
    }
}