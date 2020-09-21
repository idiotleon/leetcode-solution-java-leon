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
package com.zea7ot.leetcode.lvl4.lc1092;

import java.util.Arrays;

public class SolutionApproach0DP2Dimen {
    public String shortestCommonSupersequence(String str1, String str2) {
        char[] chs1 = str1.toCharArray(), chs2 = str2.toCharArray();
        char[] chs = longestCommonSubsequence(chs1, chs2).toCharArray();

        int i = 0, j = 0;
        StringBuilder builder = new StringBuilder();

        for (char ch : chs) {
            while (chs1[i] != ch) {
                builder.append(chs1[i++]);
            }

            while (chs2[j] != ch) {
                builder.append(chs2[j++]);
            }

            builder.append(ch);
            ++i;
            ++j;
        }

        builder.append(str1.substring(i)).append(str2.substring(j));
        return builder.toString();
    }

    private String longestCommonSubsequence(char[] chs1, char[] chs2) {
        final int L1 = chs1.length, L2 = chs2.length;
        String[][] dp = new String[L1 + 1][L2 + 1];
        for (String[] row : dp)
            Arrays.fill(row, "");

        for (int i = 1; i <= L1; i++) {
            for (int j = 1; j <= L2; j++) {
                if (chs1[i - 1] == chs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + chs1[i - 1];
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }

        return dp[L1][L2];
    }
}