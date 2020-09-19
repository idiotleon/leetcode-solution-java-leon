/**
 * https://leetcode.com/problems/regular-expression-matching/
 * 
 * Time Complexity:     O(LEN_S * LEN_P)
 * Space Complexity:    O(LEN_S * LEN_P)
 * 
 * 
 * case 1: if CHS_P[idxP] == CHS_S[idxS] :  dp[idxS][idxP] = dp[idxS - 1][idxP - 1];
 * case 2: if CHS_P[idxP] == '.' : dp[idxS][idxP] = dp[idxS - 1][idxP - 1];
 * case 3: if CHS_P[idxP] == '*': 
 *  3.1: if CHS_P[idxP - 1] != CHS_S[idxS] : dp[idxS][idxP] = dp[idxS][idxP - 2]  // in this case, a* only counts as empty
 *  3.2: if CHS_P[idxP - 1] == CHS_S[idxS] or CHS_P[idxP - 1] == '.':
 *             dp[idxS][idxP] = dp[idxS - 1][idxP]   // in this case, a* counts as multiple a 
 *          or dp[idxS][idxP] = dp[idxS][idxP - 1]   // in this case, a* counts as single a
 *          or dp[idxS][idxP] = dp[idxS][idxP - 2]   // in this case, a* counts as empty
 * 
 * References:
 *  https://leetcode.com/problems/regular-expression-matching/discuss/5651/Easy-DP-Java-Solution-with-detailed-Explanation
 */
package com.zea7ot.leetcode.lvl5.lc0010;

public class SolutionApproach0DP2Dimen {
    private static final char PLACE_HOLDER_MULTIPLE = '*';
    private static final char PLACE_HOLDER_SINGLE = '.';

    public boolean isMatch(String s, String p) {
        final int LEN_S = s.length(), LEN_P = p.length();
        final char[] CHS_S = s.toCharArray(), CHS_P = p.toCharArray();

        boolean[][] dp = new boolean[LEN_S + 1][LEN_P + 1];
        dp[0][0] = true;

        for (int idxP = 0; idxP < LEN_P; ++idxP) {
            if (CHS_P[idxP] == PLACE_HOLDER_MULTIPLE && dp[0][idxP - 1]) {
                dp[0][idxP + 1] = true;
            }
        }

        for (int idxS = 0; idxS < LEN_S; ++idxS) {
            for (int idxP = 0; idxP < LEN_P; ++idxP) {
                if (CHS_P[idxP] == PLACE_HOLDER_SINGLE) {
                    dp[idxS + 1][idxP + 1] = dp[idxS][idxP];
                }

                if (CHS_P[idxP] == CHS_S[idxS]) {
                    dp[idxS + 1][idxP + 1] = dp[idxS][idxP];
                }

                if (CHS_P[idxP] == PLACE_HOLDER_MULTIPLE) {
                    if (CHS_P[idxP - 1] != CHS_S[idxS] && CHS_P[idxP - 1] != PLACE_HOLDER_SINGLE) {
                        dp[idxS + 1][idxP + 1] = dp[idxS + 1][idxP - 1];
                    } else {
                        dp[idxS + 1][idxP + 1] = (dp[idxS + 1][idxP] || dp[idxS][idxP + 1] || dp[idxS + 1][idxP - 1]);
                    }
                }
            }
        }

        return dp[LEN_S][LEN_P];
    }
}
