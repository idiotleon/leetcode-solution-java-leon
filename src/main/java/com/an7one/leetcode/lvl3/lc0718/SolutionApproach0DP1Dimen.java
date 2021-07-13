package com.an7one.leetcode.lvl3.lc0718;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 * <p>
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(LEN(B))
 * <p>
 * References:
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/discuss/109068/JavaC%2B%2B-Clean-Code-8-lines
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP1Dimen {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null) return 0;
        final int M = A.length, N = B.length;
        int longest = 0;

        int[] dp = new int[N + 1];
        for (int i = M - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                longest = Math.max(longest, dp[j] = A[i] == B[j] ? 1 + dp[j + 1] : 0);
            }
        }

        return longest;
    }
}