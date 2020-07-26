/**
 * https://leetcode.com/problems/tallest-billboard/
 * 
 * Time Complexity:     O(N * sum)
 * Space Complexity:    O(N * sum)
 * 
 * `dp[n][i]`, max min-height one can achieve using the first `n` elements, 
 *      so that the two piles have the height difference of `i`.
 * 
 * Transition:
 *  dp[n][i + h] = max(dp[n][i + h], dp[n - 1][i])
 *  dp[n][abs(i - h)] = max(dp[n][abs(i - h)], dp[n - 1][i] + min(h, i))
 * 
 * Answer:
 *  dp[N][0]
 * 
 * References:
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-956-tallest-billboard/
 *  https://www.youtube.com/watch?v=iPRWkifQgoo
 *  https://www.youtube.com/watch?v=WqLslW2sFxU
 */
package com.zea7ot.lc.lvl4.lc0956;

import java.util.Arrays;

public class SolutionApproach0Knapsack2Dimen {
    public int tallestBillboard(int[] rods) {
        final int N = rods.length;
        int sum = 0;
        for (int rod : rods)
            sum += rod;

        int[][] dp = new int[N + 1][sum + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        dp[0][0] = 0;

        for (int i = 1; i <= N; ++i) { // 0/1 Knapsack staged by items
            int h = rods[i - 1];
            for (int j = 0; j <= sum - h; ++j) {
                if (dp[i - 1][j] < 0)
                    continue;
                // 3 possible transitions: dp[i] is ONLY dependent on dp[i - 1]
                // not used
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                // to put on the taller one
                dp[i][j + h] = Math.max(dp[i][j + h], dp[i - 1][j]);
                // to put on the shorter one
                dp[i][Math.abs(j - h)] = Math.max(dp[i][Math.abs(j - h)], dp[i - 1][j] + Math.min(h, j));
            }
        }

        return dp[N][0];
    }
}