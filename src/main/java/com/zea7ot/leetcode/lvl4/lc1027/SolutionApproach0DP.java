/**
 * https://leetcode.com/problems/longest-arithmetic-sequence/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N ^ RANGE)
 * 
 * References:
 *  https://leetcode.com/problems/longest-arithmetic-sequence/discuss/332097/JAVA-DP-O(n2)-no-HashMap-77ms-(beat-91.66)
 */
package com.zea7ot.leetcode.lvl4.lc1027;

import java.util.Arrays;

public class SolutionApproach0DP {
    public int longestArithSeqLength(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        final int RANGE = (int) 1e4;
        final int OFFSET = (int) 1e4;

        int[][] dp = new int[N][RANGE + OFFSET];
        for (int[] row : dp)
            Arrays.fill(row, 1);

        int longest = 2;
        for (int i = 1; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                int diff = nums[i] - nums[j] + OFFSET;
                dp[i][diff] = dp[j][diff] + 1;

                longest = Math.max(longest, dp[i][diff]);
            }
        }

        return longest;
    }
}