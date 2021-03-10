/**
 * https://leetcode.com/problems/uncrossed-lines/
 * 
 * Time Complexity:     O(LEN_A * LEN_B)
 * Space Complexity:    O(LEN_A * LEN_B)
 * 
 * References:
 *  https://leetcode.com/problems/uncrossed-lines/discuss/282842/JavaC%2B%2BPython-DP-The-Longest-Common-Subsequence
 */
package com.an7one.leetcode.lvl4.lc1035;

public class SolutionApproach0DP2Dimen {
    public int maxUncrossedLines(int[] A, int[] B) {
        // sanity check
        if (A == null || B == null || A.length == 0 || B.length == 0)
            return 0;

        final int LEN_A = A.length, LEN_B = B.length;
        int[][] dp = new int[LEN_A + 1][LEN_B + 1];

        for (int idxA = 1; idxA <= LEN_A; ++idxA) {
            for (int idxB = 1; idxB <= LEN_B; ++idxB) {
                if (A[idxA - 1] == B[idxB - 1]) {
                    dp[idxA][idxB] = 1 + dp[idxA - 1][idxB - 1];
                } else {
                    dp[idxA][idxB] = Math.max(dp[idxA][idxB - 1], dp[idxA - 1][idxB]);
                }
            }
        }

        return dp[LEN_A][LEN_B];
    }
}