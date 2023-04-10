/**
 * https://leetcode.com/problems/palindrome-removal/
 * 
 * Time Complexity:     O(N * N * N)
 * Space Complexity:    O(N * N)
 * 
 * References:
 *  https://leetcode.com/problems/palindrome-removal/discuss/418881/C++-O(N3)-13-lines-DP-with-explanation/583904
 *  https://leetcode.com/problems/palindrome-removal/discuss/418881/C%2B%2B-O(N3)-13-lines-DP-with-explanation
 */
package com.idiotleon.leetcode.lvl4.lc1246;

public class SolutionApproach0DP2Dimen1 {
    public int minimumMoves(int[] nums) {
        final int N = nums.length;

        int[][] dp = new int[N][N];
        for (int i = 0; i < N; ++i)
            dp[i][i] = 1;

        for (int i = 0; i < N - 1; ++i) {
            if (nums[i] == nums[i + 1])
                dp[i][i + 1] = 1;
            else
                dp[i][i + 1] = 2;
        }

        for (int len = 3; len <= N; ++len) {
            for (int lo = 0, hi = lo + len - 1; hi < N; ++lo, ++hi) {
                dp[lo][hi] = Integer.MAX_VALUE;

                if (nums[lo] == nums[hi])
                    dp[lo][hi] = dp[lo + 1][hi - 1];

                for (int k = lo; k < hi; ++k) {
                    dp[lo][hi] = Math.min(dp[lo][hi], dp[lo][k] + dp[k + 1][hi]);
                }
            }
        }

        return dp[0][N - 1];
    }
}