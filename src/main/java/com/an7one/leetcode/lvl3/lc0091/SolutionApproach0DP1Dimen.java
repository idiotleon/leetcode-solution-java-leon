package com.an7one.leetcode.lvl3.lc0091;

import com.an7one.util.Constant;

/**
 * <a href="https://leetcode.com/problems/decode-ways/">LC0091</a>
 * <p>
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * <p>
 * `dp[i]`, the number of combinations at the given index
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP1Dimen {
    public int numDecodings(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        final char[] chs = s.toCharArray();
        final int[] dp = new int[L + 1];
        dp[0] = 1;

        for (int i = 0; i < L; ++i) {
            // to add all combinations represented by dp[i] to dp[i + 1]
            if (chs[i] != '0')
                dp[i + 1] += dp[i];

            if (i < L - 1) {
                // depending on the relative relationships of letter (i) and letter (i + 1),
                // since there are 26 letters in total,
                // as the position i, the previous(current) position, we are only interested in
                // '1' or '2'
                // as the position i + 1, the current(next) position, we are only interested in
                // ['0', '6'], both inclusive
                if ((chs[i] == '1') // if substring(0, i) ends with '1'
                        // if substring(0, i) ends with '2':
                        || (chs[i] == '2' && chs[i + 1] >= '0' && chs[i + 1] <= '6')) {
                    // to add all combinations represented by dp[i] to dp[i + 2].
                    // in other words, were the above conditions true: dp[idx] = dp[idx - 1] +
                    // dp[idx - 2]
                    dp[i + 2] += dp[i];
                }
            }
        }

        return dp[L];
    }
}