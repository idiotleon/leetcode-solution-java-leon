/**
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L ^ 2)
 */
package com.idiotleon.leetcode.lvl4.lc1312;

public class SolutionApproach0DP2Dimen1 {
    public int minInsertions(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        int[][] dp = new int[L][L];
        for (int i = L - 1; i >= 0; --i) {
            dp[i][i] = 1;
            for (int j = i + 1; j < L; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return L - dp[0][L - 1];
    }
}