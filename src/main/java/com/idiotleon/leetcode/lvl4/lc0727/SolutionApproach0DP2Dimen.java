/**
 * https://leetcode.com/problems/minimum-window-subsequence/
 * 
 * Time Complexity:     O(LEN_T * LEN_S)
 * Space Complexity:    O(LEN_T * LEN_S)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-window-subsequence/discuss/109362/Java-Super-Easy-DP-Solution-(O(mn))
 */
package com.idiotleon.leetcode.lvl4.lc0727;

public class SolutionApproach0DP2Dimen {
    public String minWindow(String S, String T) {
        final int LEN_T = T.length(), LEN_S = S.length();
        int[][] dp = new int[LEN_T + 1][LEN_S + 1];
        for (int idxS = 0; idxS <= LEN_S; ++idxS) {
            dp[0][idxS] = idxS + 1;
        }

        for (int idxT = 1; idxT <= LEN_T; ++idxT) {
            for (int idxS = 1; idxS <= LEN_S; ++idxS) {
                if (T.charAt(idxT - 1) == S.charAt(idxS - 1)) {
                    dp[idxT][idxS] = dp[idxT - 1][idxS - 1];
                } else {
                    dp[idxT][idxS] = dp[idxT][idxS - 1];
                }
            }
        }

        int start = 0, len = LEN_S + 1;
        for (int idxS = 1; idxS <= LEN_S; ++idxS) {
            if (dp[LEN_T][idxS] == 0)
                continue;

            if (idxS - dp[LEN_T][idxS] + 1 < len) {
                start = dp[LEN_T][idxS] - 1;
                len = idxS - dp[LEN_T][idxS] + 1;
            }
        }

        return len == LEN_S + 1 ? "" : S.substring(start, start + len);
    }
}