/**
 * https://leetcode.com/problems/shortest-common-supersequence/
 * 
 * Time Complexity:     O(L1 * L2)
 * Space Complexity:    O(L1 * L2 * L)
 *  L, the length of Longest Common Subsequence
 * 
 * a bottom-up approach
 * 
 * References:
 *  https://leetcode.com/problems/shortest-common-supersequence/discuss/312710/C++Python-Find-the-LCS/434150
 *  https://leetcode.com/problems/shortest-common-supersequence/discuss/312710/C++Python-Find-the-LCS/290904
 */
package com.an7one.leetcode.lvl4.lc1092;

import java.util.Arrays;

public class SolutionApproach0DP2Dimen {
    public String shortestCommonSupersequence(String str1, String str2) {
        final int L1 = str1.length(), L2 = str2.length();
        final char[] CHS1 = str1.toCharArray(), CHS2 = str2.toCharArray();
        final char[] CHS = longestCommonSubsequence(CHS1, CHS2).toCharArray();

        int idx1 = 0, idx2 = 0;
        StringBuilder builder = new StringBuilder();

        for (final char CH : CHS) {
            while (idx1 < L1 && CHS1[idx1] != CH) {
                builder.append(CHS1[idx1++]);
            }

            while (idx2 < L2 && CHS2[idx2] != CH) {
                builder.append(CHS2[idx2++]);
            }

            builder.append(CH);
            ++idx1;
            ++idx2;
        }

        builder.append(str1.substring(idx1)).append(str2.substring(idx2));
        return builder.toString();
    }

    private String longestCommonSubsequence(final char[] CHS1, final char[] CHS2) {
        final int L1 = CHS1.length, L2 = CHS2.length;
        String[][] dp = new String[L1 + 1][L2 + 1];
        for (String[] row : dp) {
            Arrays.fill(row, "");
        }

        for (int idx1 = 1; idx1 <= L1; ++idx1) {
            for (int idx2 = 1; idx2 <= L2; ++idx2) {
                if (CHS1[idx1 - 1] == CHS2[idx2 - 1]) {
                    dp[idx1][idx2] = dp[idx1 - 1][idx2 - 1] + CHS1[idx1 - 1];
                } else {
                    dp[idx1][idx2] = dp[idx1 - 1][idx2].length() > dp[idx1][idx2 - 1].length() ? dp[idx1 - 1][idx2]
                            : dp[idx1][idx2 - 1];
                }
            }
        }

        return dp[L1][L2];
    }
}