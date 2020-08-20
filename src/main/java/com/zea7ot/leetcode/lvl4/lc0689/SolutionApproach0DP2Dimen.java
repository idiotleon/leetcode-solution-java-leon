/**
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
 * 
 * Time Complexity:     O(3 * N) ~ O(N)
 * Space Complexity:    O(4 * N) ~ O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/discuss/108230/Clean-Java-DP-O(n)-Solution.-Easy-extend-to-Sum-of-K-Non-Overlapping-SubArrays./110493
 *  https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/discuss/108230/Clean-Java-DP-O(n)-Solution.-Easy-extend-to-Sum-of-K-Non-Overlapping-SubArrays.
 */
package com.zea7ot.leetcode.lvl4.lc0689;

public class SolutionApproach0DP2Dimen {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int[3];
        // sanity check
        if (nums == null || k <= 0 || nums.length < 3 * k)
            return ans;

        final int N = nums.length;
        int[] prefixSums = new int[N + 1];
        for (int i = 1; i <= N; ++i)
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];

        int[][] dp = new int[4][N + 1];
        int[][] pos = new int[4][N + 1];

        for (int i = 1; i <= 3; ++i) {
            for (int j = k * i; j <= N; ++j) {
                int curSum = prefixSums[j] - prefixSums[j - k] + dp[i - 1][j - k];
                if (curSum > dp[i][j - 1]) {
                    dp[i][j] = curSum;
                    pos[i][j] = j - k;
                } else {
                    dp[i][j] = dp[i][j - 1];
                    pos[i][j] = pos[i][j - 1];
                }
            }
        }

        int idx = N;
        for (int i = 2; i >= 0; --i) {
            ans[i] = pos[i + 1][idx];
            idx = ans[i];
        }

        return ans;
    }
}