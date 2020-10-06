/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/russian-doll-envelopes/discuss/82759/Simple-DP-solution/86996
 *  https://www.geeksforgeeks.org/box-stacking-problem-dp-22/
 */
package com.zea7ot.leetcode.lvl5.lc0354;

import java.util.Arrays;

public class SolutionApproach0DP2Dimen1 {
    public int maxEnvelopes(int[][] envelopes) {
        // sanity check
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length < 2)
            return 0;

        final int N = envelopes.length;
        int max = 1;
        // todo: do not understand
        Arrays.sort(envelopes, (a, b) -> Integer.compare(b[0] * b[1], a[0] * a[1]));
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            int[] inner = envelopes[i];
            for (int j = 0; j < i; j++) {
                int[] outer = envelopes[j];
                if (outer[0] > inner[0] && outer[1] > inner[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}