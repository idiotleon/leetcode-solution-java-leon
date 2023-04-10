/**
 * https://leetcode.com/problems/burst-balloons/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-312-burst-balloons/
 *  https://www.youtube.com/watch?v=z3hu2Be92UA
 */
package com.idiotleon.leetcode.lvl4.lc0312;

public class SolutionApproach0DFSMemo {
    public int maxCoins(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        // to pad the current `nums` with 2 heading and trailing 1s
        int[] padded = new int[N + 2];
        for (int i = 0; i < N; ++i) {
            padded[i + 1] = nums[i];
        }
        padded[0] = padded[N + 1] = 1;

        int[][] memo = new int[N + 2][N + 2];
        return maxCoins(1, N, padded, memo);
    }

    private int maxCoins(int lo, int hi, int[] padded, int[][] memo) {
        if (lo > hi)
            return 0;
        if (lo == hi)
            return padded[lo - 1] * padded[lo] * padded[lo + 1];
        if (memo[lo][hi] > 0)
            return memo[lo][hi];

        int maxCoins = 0;
        for (int k = lo; k <= hi; ++k) {
            maxCoins = Math.max(maxCoins, maxCoins(lo, k - 1, padded, memo)
                    + padded[lo - 1] * padded[k] * padded[hi + 1] + maxCoins(k + 1, hi, padded, memo));
        }
        return memo[lo][hi] = maxCoins;
    }
}