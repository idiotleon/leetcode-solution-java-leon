/**
 * https://leetcode.com/problems/split-array-largest-sum/ 
 * 
 * Time Complexity:     O(N * N * m)
 * Space Complexity:    O(N * m)
 * 
 * this approach applies to situations where there is any negative number
 */
package com.zea7ot.leetcode.lvl4.lc0410;

import java.util.Arrays;

public class SolutionApproach0DP2Dimen {
    public int splitArray(int[] nums, int m) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[][] dp = new int[N + 1][m + 1];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        dp[0][0] = 0;

        int[] prefixSums = new int[N + 1];
        for (int i = 0; i < N; ++i)
            prefixSums[i + 1] = prefixSums[i] + nums[i];

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= m; ++j) {
                for (int k = 0; k < i; ++k) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], prefixSums[i] - prefixSums[k]));
                }
            }
        }

        return dp[N][m];
    }
}