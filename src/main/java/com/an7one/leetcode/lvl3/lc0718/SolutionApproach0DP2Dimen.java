package com.an7one.leetcode.lvl3.lc0718;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 * <p>
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(LEN(A) * LEN(B))
 * <p>
 * References:
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/discuss/109039/Concise-Java-DP%3A-Same-idea-of-Longest-Common-Substring
 */

@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP2Dimen {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null) return 0;
        final int M = A.length, N = B.length;
        int longest = 0;

        // dp[i][j] represents the length of longest common subarray 
        // ending with A[i] and B[j]
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else {
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        longest = Math.max(longest, dp[i][j]);
                    }
                }
            }
        }

        return longest;
    }
}