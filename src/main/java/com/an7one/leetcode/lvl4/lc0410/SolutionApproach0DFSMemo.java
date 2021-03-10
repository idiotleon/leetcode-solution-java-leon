/**
 * https://leetcode.com/problems/split-array-largest-sum/
 * 
 * Time Complexity:     O(m * (N ^ 2))
 * Space Complexity:    O(m * N)
 * 
 * this approach applies to situations where there is any negative number
 * 
 * 
 * Subproblems: shorter, fewer groups
 * 
 *  memo[i][j]: answer of sub-problem, splitting nums[0] ~ nums[j] into i groups
 *  memo[1][j]: sum(0, j)
 *  memo[i][j]: Math.min{Math.max(memo[i - 1][k], sums(k + 1, j), ...)} 0 <= k < j
 * 
 * 
 * References:
 *  https://youtu.be/_k-Jb4b7b_0
 */
package com.an7one.leetcode.lvl4.lc0410;

import java.util.Arrays;

public class SolutionApproach0DFSMemo {
    public int splitArray(int[] nums, int m) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int[][] memo = new int[N][m + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int[] prefixSums = new int[N];
        prefixSums[0] = nums[0];
        for (int i = 1; i < N; ++i) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }

        return splitArray(N - 1, m, prefixSums, nums, memo);
    }

    private int splitArray(int k, int m, int[] prefixSums, int[] nums, int[][] memo) {
        if (m == 1)
            return prefixSums[k];
        if (m > k + 1)
            return Integer.MAX_VALUE;
        if (memo[k][m] != Integer.MAX_VALUE)
            return memo[k][m];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            res = Math.min(res, Math.max(splitArray(i, m - 1, prefixSums, nums, memo), prefixSums[k] - prefixSums[i]));
        }

        return memo[k][m] = res;
    }
}