/**
 * https://leetcode.com/problems/burst-balloons/
 * 
 * Time Complexity:     ?O(N * N * N)
 * Space Complexity:    O(N * N)
 * 
 * `dp[i][k]`, the maximum score with s[i : j] balloons burst
 * 
 * References:
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-312-burst-balloons/
 *  https://www.youtube.com/watch?v=z3hu2Be92UA
 *  https://youtu.be/FLbqgyJ-70I?t=7040
 */
package com.an7one.leetcode.lvl4.lc0312;

public class SolutionApproach0DP2Dimen {
    public int maxCoins(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[] padded = new int[N + 2];
        for (int i = 0; i < N; ++i) {
            padded[i + 1] = nums[i];
        }
        padded[0] = padded[N + 1] = 1;

        int[][] dp = new int[N + 2][N + 2];
        for (int len = 1; len <= N; ++len) {
            for (int i = 1; i + len <= N + 1; ++i) {
                int j = i + len - 1;
                int best = 0;
                for (int k = i; k <= j; ++k) {
                    best = Math.max(best, dp[i][k - 1] + padded[i - 1] * padded[k] * padded[j + 1] + dp[k + 1][j]);
                }
                dp[i][j] = best;
            }
        }

        return dp[1][N];
    }
}