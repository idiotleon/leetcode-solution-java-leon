/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 *
 * Time Complexity:     O(`N` ^ 2)
 * Space Complexity:    O(`N`)
 *
 * References:
 *  https://leetcode.com/problems/russian-doll-envelopes/
 */
package com.an7one.leetcode.lvl4.lc0354;

import java.util.Arrays;

public class SolutionApproach0DP1Dimen {
    public int maxEnvelopes(int[][] envelopes) {
        final int N = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> Integer.compare(a[0], b[0]));
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        int most = 0;

        for (int hi = 0; hi < N; ++hi) {
            int[] outer = envelopes[hi];

            for (int lo = 0; lo < hi; ++lo) {
                int[] inner = envelopes[lo];

                if (outer[0] > inner[0] && outer[1] > inner[1]) {
                    dp[hi] = Math.max(dp[hi], 1 + dp[lo]);
                }
            }

            most = Math.max(most, dp[hi]);
        }

        return most;
    }
}
