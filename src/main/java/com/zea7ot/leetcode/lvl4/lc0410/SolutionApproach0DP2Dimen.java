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
        // sanity check, not required
        // if (nums == null || nums.length == 0)
        // return 0;

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

        for (int hi = 1; hi <= N; ++hi) {
            // the actual split(s), starting with 1
            for (int partition = 1; partition <= m; ++partition) {
                // [0, lo], [lo, lo]: where to split the array
                for (int lo = 0; lo < hi; ++lo) {
                    int subarraySum = PREFIX_SUMS[hi] - PREFIX_SUMS[lo];
                    dp[hi][partition] = Math.min(dp[hi][partition], Math.max(dp[lo][partition - 1], subarraySum));
                }
            }
        }

        return dp[N][m];
    }
}