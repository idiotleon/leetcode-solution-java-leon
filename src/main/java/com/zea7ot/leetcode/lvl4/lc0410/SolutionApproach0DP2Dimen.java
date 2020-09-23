/**
 * https://leetcode.com/problems/split-array-largest-sum/ 
 * 
 * Time Complexity:     O(N * m * N)
 * Space Complexity:    O(N * m)
 * 
 * this approach applies to situations where there is are negative numbers
 * 
 * References:
 *  https://youtu.be/FLbqgyJ-70I?t=6300
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
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;

        // 1-indexed, instead of 0-indexed
        final int[] PREFIX_SUMS = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            PREFIX_SUMS[i + 1] = PREFIX_SUMS[i] + nums[i];
        }

        // 1-indexed, instead of 0-indexed
        for (int i = 1; i <= N; ++i) {
            // the actual split(s), starting with 1
            for (int j = 1; j <= m; ++j) {
                // [0, k], [k, i]: where to split the array
                for (int k = 0; k < i; ++k) {
                    int subarraySum = PREFIX_SUMS[i] - PREFIX_SUMS[k];
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], subarraySum));
                }
            }
        }

        return dp[N][m];
    }
}