/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/russian-doll-envelopes/discuss/82759/Simple-DP-solution
 *  https://www.geeksforgeeks.org/box-stacking-problem-dp-22/
 */
package com.zea7ot.leetcode.lvl5.lc0354;

import java.util.Arrays;

public class SolutionApproach0DP2Dimen {
    public int maxEnvelopes(int[][] envelopes) {
        // sanity check
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length < 2)
            return 0;

        final int N = envelopes.length;
        int most = 1;
        Arrays.sort(envelopes, (a, b) -> Integer.compare(a[0], b[0]));

        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for (int hi = 0; hi < N; ++hi) {
            int[] outer = envelopes[hi];

            for (int lo = 0; lo < hi; ++lo) {
                int[] inner = envelopes[lo];
                if (outer[0] > inner[0] && outer[1] > inner[1]) { // if `inner` can be fit into `outer`
                    dp[hi] = Math.max(dp[hi], dp[lo] + 1);
                }
            }

            most = Math.max(most, dp[hi]);
        }

        return most;
    }
}