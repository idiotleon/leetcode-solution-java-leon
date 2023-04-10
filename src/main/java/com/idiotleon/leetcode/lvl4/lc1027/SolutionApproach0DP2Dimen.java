/**
 * https://leetcode.com/problems/longest-arithmetic-sequence/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N * RANGE)
 * 
 * References:
 *  https://leetcode.com/problems/longest-arithmetic-sequence/discuss/332097/JAVA-DP-O(n2)-no-HashMap-77ms-(beat-91.66)
 */
package com.idiotleon.leetcode.lvl4.lc1027;

import java.util.Arrays;

public class SolutionApproach0DP2Dimen {
    public int longestArithSeqLength(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        final int RANGE = (int) 1e4;
        final int OFFSET = (int) 1e4;

        int[][] dp = new int[N][RANGE + OFFSET];
        for (int[] row : dp) {
            Arrays.fill(row, 1);
        }

        int longest = 2;
        for (int hi = 1; hi < N; ++hi) {
            for (int lo = 0; lo < hi; ++lo) {
                int diff = nums[hi] - nums[lo] + OFFSET;
                dp[hi][diff] = dp[lo][diff] + 1;

                longest = Math.max(longest, dp[hi][diff]);
            }
        }

        return longest;
    }
}