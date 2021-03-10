/**
 * https://leetcode.com/problems/regular-expression-matching/
 * 
 * Time Complexity:     O(LEN_S * LEN_P)
 * Space Complexity:    O(LEN_S * LEN_P)
 * 
 * References:
 *  https://www.youtube.com/watch?v=l3hda49XcDE&t=389s
 */
package com.an7one.leetcode.lvl5.lc0010;

public class SolutionApproach0DP2Dimen1 {
    private static final char PLACE_HOLDER_MULTIPLE = '*';
    private static final char PLACE_HOLDER_SINGLE = '.';

    public boolean isMatch(String s, String p) {
        final int LEN_S = s.length(), LEN_P = p.length();
        final char[] CHS_S = s.toCharArray(), CHS_P = p.toCharArray();

        boolean[][] dp = new boolean[LEN_S + 1][LEN_P + 1];
        dp[0][0] = true;

        for (int idxP = 1; idxP <= LEN_P; ++idxP) {
            if (CHS_P[idxP - 1] == PLACE_HOLDER_MULTIPLE) {
                dp[0][idxP] = dp[0][idxP - 2];
            }
        }

        for (int idxS = 1; idxS <= LEN_S; ++idxS) {
            for (int idxP = 1; idxP <= LEN_P; ++idxP) {
                if (CHS_P[idxP - 1] == PLACE_HOLDER_SINGLE || CHS_P[idxP - 1] == CHS_S[idxS - 1]) {
                    dp[idxS][idxP] = dp[idxS - 1][idxP - 1];
                } else if (CHS_P[idxP - 1] == PLACE_HOLDER_MULTIPLE) {
                    // 0 occurrence: dp[i][j - 2]
                    dp[idxS][idxP] = dp[idxS][idxP - 2];
                    // 1 or more occurrences:
                    // dp[idxS - 1][idxP] if CHS[idxS] == CHS_P[idxP - 1] || CHS_P[idxP - 1] ==
                    // PLACE_HOLDER_SINGLE
                    // (str[idxS] == pattern[idxP - 1] || pattern[idxP - 1] == PLACE_HOLDER_SINGLE)

                    if (CHS_P[idxP - 2] == PLACE_HOLDER_SINGLE || CHS_P[idxP - 2] == CHS_S[idxS - 1]) {
                        dp[idxS][idxP] = dp[idxS][idxP] || dp[idxS - 1][idxP];
                    }
                } else {
                    dp[idxS][idxP] = false;
                }
            }
        }

        return dp[LEN_S][LEN_P];
    }
}