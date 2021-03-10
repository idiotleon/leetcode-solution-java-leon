/**
 * https://leetcode.com/problems/paint-house-ii/
 * 
 * Time Complexity:     O(N * (K ^ 2))
 * Space Complexity:    O(N * K)
 * 
 * `dp[i][j]` = min{ dp[i - 1][j'] + costs[i][j]}
 *      j' = 1, 2, 3, ..., (j - 1), (j + 1), ..., `K` (but not `j`)
 * 
 * a top-down approach
 * 
 * References:
 *  https://leetcode.com/problems/paint-house-ii/discuss/69492/AC-Java-solution-without-extra-space/71565
 *  https://youtu.be/FLbqgyJ-70I?t=1433
 */
package com.an7one.leetcode.lvl4.lc0265;

public class SolutionApproach1DP2Dimen {
    public int miKostII(int[][] costs) {
        // sanity check
        if (costs == null || costs.length == 0 || costs[0].length == 0)
            return 0;

        final int N = costs.length, K = costs[0].length;
        int[][] dp = new int[N][K];
        for (int k = 0; k < K; ++k) {
            dp[0][k] = costs[0][k];
        }

        for (int i = 1; i < N; ++i) {
            for (int j = 0; j < K; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < K; ++k) {
                    if (j == k)
                        continue;

                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i][j]);
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int k = 0; k < K; ++k) {
            minCost = Math.min(minCost, dp[N - 1][k]);
        }

        return minCost;
    }
}