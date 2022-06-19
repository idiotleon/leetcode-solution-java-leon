package com.an7one.leetcode.lvl3.lc0005;

import com.an7one.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">Description</a>
 *
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L ^ 2)
 *
 * `dp[i][j]`, whether `str.substring(i, j)` is a palindrome
 *
 * References:
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/discuss/2921/Share-my-Java-solution-using-dynamic-programming/223961">...</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP2Dimen {
    public String longestPalindrome(String s) {
        // sanity check
        if (s == null || s.length() < 2)
            return s;

        final int L = s.length();
        final char[] chs = s.toCharArray();

        int start = 0, end = 0;

        boolean[][] dp = new boolean[L][L];

        for (int i = L - 1; i >= 0; --i) {
            for (int j = i; j < L; ++j) {
                dp[i][j] = chs[i] == chs[j] && (j - i < 2 || dp[i + 1][j - 1]);

                if (dp[i][j] && j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }
}