/**
 * https://leetcode.com/problems/valid-palindrome-iii/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/valid-palindrome-iii/discuss/397606/Find-Longest-Palindromic-Subsequence./358118
 */
package com.an7one.leetcode.lvl4.lc1216;

public class SolutionApproach0DP2Dimen1 {
    public boolean isValidPalindrome(String s, int k) {
        // sanity check, not necessary
        // if (s == null || s.isEmpty() || k <= 0)
        // return false;

        final int L = s.length();
        final char[] CHS = s.toCharArray();
        int[][] dp = new int[L][L];

        for (int lo = L - 1; lo >= 0; --lo) {
            dp[lo][lo] = 1;
            for (int hi = lo + 1; hi < L; ++hi) {
                if (CHS[lo] == CHS[hi])
                    dp[lo][hi] = dp[lo + 1][hi - 1] + 2;
                else
                    dp[lo][hi] = Math.max(dp[lo + 1][hi], dp[lo][hi - 1]);
            }
        }

        return L - dp[0][L - 1] <= k;
    }
}