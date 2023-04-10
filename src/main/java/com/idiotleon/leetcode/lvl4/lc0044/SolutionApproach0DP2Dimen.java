/**
 * https://leetcode.com/problems/wildcard-matching/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://www.youtube.com/watch?v=3ZDZ-N0EPV0&t=121s
 */
package com.idiotleon.leetcode.lvl4.lc0044;

public class SolutionApproach0DP2Dimen {
    public boolean isMatch(String s, String p) {

        final int LEN_S = s.length();
        final int LEN_P = p.length();

        final char[] CHS_S = s.toCharArray();
        final char[] CHS_P = p.toCharArray();

        // to replace multiple * with single one *
        // e.g. a**b**c ---> a*b*c
        int writeIndex = 0;
        boolean isFirst = true;
        for (int i = 0; i < LEN_P; i++) {
            if (CHS_P[i] == '*') {
                if (isFirst) {
                    CHS_P[writeIndex++] = CHS_P[i];
                    isFirst = false;
                }
            } else {
                CHS_P[writeIndex++] = CHS_P[i];
                isFirst = true;
            }
        }

        boolean dp[][] = new boolean[LEN_S + 1][writeIndex + 1];

        if (writeIndex > 0 && CHS_P[0] == '*')
            dp[0][1] = true;

        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++)
            for (int j = 1; j < dp[0].length; j++)
                if (CHS_P[j - 1] == '?' || CHS_S[i - 1] == CHS_P[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else if (CHS_P[j - 1] == '*')
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];

        return dp[LEN_S][writeIndex];
    }
}