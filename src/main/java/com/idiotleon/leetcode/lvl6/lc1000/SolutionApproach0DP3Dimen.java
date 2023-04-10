/**
 * https://leetcode.com/problems/minimum-cost-to-merge-stones/
 * 
 * Time Complexity:     O(N ^ 3)
 * Space Complexity:    O((N ^ 2) * K)
 * 
 * State:
 *  `dp[i][j][k]`, min cost to merge subarray (`i` - `j`) into `k` piles
 * 
 * Initialization:
 *  dp[i][j][k] = 0 if `i` == `j` and `k` == 1 else Integer.MAX_VALUE
 * 
 * Transition:
 *  1. dp[i][j][k] = min(dp[i][m][1] + dp[m + 1][j][k - 1]), for all i <= m < j
 *  2. dp[i][j][1] = dp[i][j][K] + sum(nums[i] - nums[j])
 * 
 * Answer:
 *  dp[0][N - 1][1]
 * 
 * References:
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-1000-minimum-cost-to-merge-stones/
 *  https://www.youtube.com/watch?v=FabkoUzs64o
 *  https://youtu.be/FLbqgyJ-70I?t=8074
 */
package com.idiotleon.leetcode.lvl6.lc1000;

import java.util.Arrays;

public class SolutionApproach0DP3Dimen {
    public int mergeStones(int[] stones, int K) {
        final int N = stones.length;
        // sanity check
        if ((N - 1) % (K - 1) != 0)
            return -1;

        int[] prefixSums = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            prefixSums[i + 1] = prefixSums[i] + stones[i];
        }

        int[][][] dp = new int[N][N][K + 1];
        for (int[][] matrix : dp)
            for (int[] row : matrix)
                Arrays.fill(row, Integer.MAX_VALUE);

        for (int i = 0; i < N; ++i)
            dp[i][i][1] = 0;

        for (int len = 2; len <= N; ++len) { // the length of the subproblem
            for (int i = 0; i <= N - len; ++i) { // start
                int j = i + len - 1; // end
                for (int k = 2; k <= K; ++k) { // piles
                    for (int m = i; m < j; m += K - 1) // splitting point
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][m][1] + dp[m + 1][j][k - 1]);
                }
                dp[i][j][1] = dp[i][j][K] + prefixSums[j + 1] - prefixSums[i];
            }
        }

        return dp[0][N - 1][1];
    }
}