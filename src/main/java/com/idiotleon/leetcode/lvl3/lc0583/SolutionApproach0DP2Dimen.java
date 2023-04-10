/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 * 
 * Time Complexity:     O(L1 * L2)
 * Space Complexity:    O(L1 * L2)
 * 
 * References:
 *  https://leetcode.com/problems/delete-operation-for-two-strings/discuss/103214/Java-DP-Solution-(Longest-Common-Subsequence)/106401
 */
package com.idiotleon.leetcode.lvl3.lc0583;

public class SolutionApproach0DP2Dimen {
    public int minDistance(String word1, String word2) {
        final int L1 = word1.length(), L2 = word2.length();

        int[][] dp = new int[L1 + 1][L2 + 1];
        for (int idx1 = 1; idx1 <= L1; ++idx1) {
            for (int idx2 = 1; idx2 <= L2; ++idx2) {
                if (word1.charAt(idx1 - 1) == word2.charAt(idx2 - 1)) {
                    dp[idx1][idx2] = dp[idx1 - 1][idx2 - 1] + 1;
                } else {
                    dp[idx1][idx2] = Math.max(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1]);
                }
            }
        }

        int common = dp[L1][L2];
        return (L1 - common) + (L2 - common);
    }
}