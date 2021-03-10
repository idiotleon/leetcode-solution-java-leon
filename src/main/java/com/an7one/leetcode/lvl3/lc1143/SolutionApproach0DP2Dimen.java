/**
 * https://leetcode.com/problems/longest-common-subsequence/
 * 
 * Time Complexity:     O(L1 * L2)
 * Space Complexity:    O(L1 * L2)
 * 
 * References:
 *  https://leetcode.com/problems/longest-common-subsequence/discuss/348884/C%2B%2B-with-picture-O(nm)
 */
package com.an7one.leetcode.lvl3.lc1143;

public class SolutionApproach0DP2Dimen {
    public int longestCommonSubsequence(String text1, String text2) {
        final int L1 = text1.length(), L2 = text2.length();
        final char[] CHS1 = text1.toCharArray();
        final char[] CHS2 = text2.toCharArray();
        int[][] dp = new int[L1 + 1][L2 + 1];

        for (int idx1 = 1; idx1 <= L1; ++idx1) {
            for (int idx2 = 1; idx2 <= L2; ++idx2) {
                if (CHS1[idx1 - 1] == CHS2[idx2 - 1]) {
                    dp[idx1][idx2] = dp[idx1 - 1][idx2 - 1] + 1;
                } else {
                    dp[idx1][idx2] = Math.max(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1]);
                }
            }
        }

        return dp[L1][L2];
    }
}