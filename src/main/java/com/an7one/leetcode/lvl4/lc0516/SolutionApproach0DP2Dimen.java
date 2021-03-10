/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L ^ 2)
 * 
 * `dp[i][k]`, the longest length of the palindrome in S[i : j]
 * 
 * Transition:
 *       {        dp[i][j]         }
 *       i x x x x x x x x x x x x j
 *        {    dp[i + 1][j - 1]   }
 * 
 * the first loop is about length/range
 * the second loop is about starting/ending positions
 * 
 * 
 * References:
 *  https://youtu.be/FLbqgyJ-70I?t=6680
 */
package com.an7one.leetcode.lvl4.lc0516;

public class SolutionApproach0DP2Dimen {
    public int longestPalindromeSubseq(String str) {
        // sanity check
        if (str == null || str.isEmpty())
            return 0;

        final int L = str.length();
        final char[] CHS = str.toCharArray();
        int[][] dp = new int[L + 1][L + 1];

        for (int len = 1; len <= L; ++len) {
            for (int i = 1; i + len - 1 <= L; ++i) {
                int j = i + len - 1;
                if (len == 1)
                    dp[i][j] = 1;
                else if (CHS[i - 1] == CHS[j - 1]) // to turn it into 0-indexed coordinate
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }

        return dp[1][L];
    }
}