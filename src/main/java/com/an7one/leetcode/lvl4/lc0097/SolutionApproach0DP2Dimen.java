package com.an7one.leetcode.lvl4.lc0097;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/interleaving-string/
 *
 * Time Complexity:     O(L1 * L2)
 * Space Complexity:    O(L1 * L2)
 *
 * References:
 *  https://leetcode.com/problems/interleaving-string/discuss/31879/My-DP-solution-in-C++/30687
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP2Dimen {
    public boolean isInterleave(String s1, String s2, String s3) {
        final int L1 = s1.length(), L2 = s2.length(), L3 = s3.length();
        // sanity check
        if (L1 + L2 != L3)
            return false;

        final char[] CHS1 = s1.toCharArray();
        final char[] CHS2 = s2.toCharArray();
        final char[] CHS3 = s3.toCharArray();

        boolean[][] dp = new boolean[L1 + 1][L2 + 1];
        for (int idx1 = 0; idx1 <= L1; ++idx1) {
            for (int idx2 = 0; idx2 <= L2; ++idx2) {
                if (idx1 == 0 && idx2 == 0)
                    dp[idx1][idx2] = true;
                else {
                    int idx3 = idx1 + idx2 - 1;
                    dp[idx1][idx2] = ((idx1 > 0 && dp[idx1 - 1][idx2] && CHS1[idx1 - 1] == CHS3[idx3])
                            || (idx2 > 0 && dp[idx1][idx2 - 1] && CHS2[idx2 - 1] == CHS3[idx3]));
                }
            }
        }

        return dp[L1][L2];
    }
}