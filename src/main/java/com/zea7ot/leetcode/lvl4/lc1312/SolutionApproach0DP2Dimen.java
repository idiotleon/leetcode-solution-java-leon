/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 * 
 * Time Complexity:     O(L ^ 2) + O(L)
 * Space Complexity:    O(L ^ 2)
 */
package com.zea7ot.leetcode.lvl4.lc1312;

public class SolutionApproach0DP2Dimen {
    public int minInsertions(String s) {
        // sanity check, not necessary
        // if (s == null || s.isEmpty())
        // return 0;

        final int L = s.length();
        String t = new StringBuilder(s).reverse().toString();

        int longest = longestCommonSubsequence(s, t);
        return L - longest;
    }

    private int longestCommonSubsequence(String str1, String str2) {
        final int L1 = str1.length(), L2 = str2.length();
        final char[] CHS1 = str1.toCharArray(), CHS2 = str2.toCharArray();

        int[][] dp = new int[L1 + 1][L2 + 1];

        for (int idx1 = 1; idx1 <= L1; ++idx1) {
            for (int idx2 = 1; idx2 <= L2; ++idx2) {
                if (CHS1[idx1 - 1] == CHS2[idx2 - 1]) {
                    dp[idx1][idx2] = dp[idx1 - 1][idx2 - 1] + 1;
                } else {
                    dp[idx1][idx2] = Math.max(dp[idx1][idx2 - 1], dp[idx1 - 1][idx2]);
                }
            }
        }

        return dp[L1][L2];
    }
}
