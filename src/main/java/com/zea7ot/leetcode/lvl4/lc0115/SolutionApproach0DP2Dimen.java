/**
 * https://leetcode.com/problems/distinct-subsequences/
 * 
 * Time Complexity:     O(LEN_S * LEN_T)
 * Space Complexity:    O(LEN_S * LEN_T)
 * 
 * References:
 *  https://leetcode.com/problems/distinct-subsequences/discuss/37413/Concise-JAVA-solution-based-on-DP
 *  https://leetcode.wang/leetcode-115-Distinct-Subsequences.html
 */
package com.zea7ot.leetcode.lvl4.lc0115;

public class SolutionApproach0DP2Dimen {
    public int numDistinct(String s, String t) {
        final int LEN_S = s.length(), LEN_T = t.length();
        final char[] CHS_S = s.toCharArray();
        final char[] CHS_T = t.toCharArray();
        int[][] dp = new int[LEN_S + 1][LEN_T + 1];
        for (int idxS = 0; idxS < LEN_S; ++idxS) {
            dp[idxS][0] = 1;
        }

        for (int idxS = 1; idxS <= LEN_S; ++idxS) {
            for (int idxT = 1; idxT <= LEN_T; ++idxT) {
                if (CHS_S[idxS - 1] == CHS_T[idxT - 1]) {
                    dp[idxS][idxT] = dp[idxS - 1][idxT] + dp[idxS - 1][idxT - 1];
                } else {
                    dp[idxS][idxT] = dp[idxS - 1][idxT];
                }
            }
        }

        return dp[LEN_S][LEN_T];
    }
}