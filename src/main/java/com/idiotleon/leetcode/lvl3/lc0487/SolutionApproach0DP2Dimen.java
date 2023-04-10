/**
 * https://leetcode.com/problems/max-consecutive-ones-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(2 * N) ~ O(N)
 * 
 * `dp[i][j]`
 *  j = 0, not flipped before
 *  j = 1, already flipped before
 * 
 * References:
 *  https://youtu.be/FLbqgyJ-70I?t=2004
 */
package com.idiotleon.leetcode.lvl3.lc0487;

public class SolutionApproach0DP2Dimen {
    public int findMaxConsecutiveOnes(int[] nums) {
        final int N = nums.length;

        int[][] dp = new int[N][2];
        // not flipped
        dp[0][0] = nums[0];
        // flipped
        dp[0][1] = 1;
        int longest = Math.max(dp[0][0], dp[0][1]);

        for (int i = 1; i < N; ++i) {
            if (nums[i] == 0) {
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            }

            longest = Math.max(longest, dp[i][0]);
            longest = Math.max(longest, dp[i][1]);
        }

        return longest;
    }
}
