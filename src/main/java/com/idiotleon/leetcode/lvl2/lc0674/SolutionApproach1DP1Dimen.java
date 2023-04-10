/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/longest-continuous-increasing-subsequence/discuss/107351/Java-solution-DP
 */
package com.idiotleon.leetcode.lvl2.lc0674;

public class SolutionApproach1DP1Dimen {
    public int findLengthOfLCIS(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[] dp = new int[N];
        dp[0] = 1;

        int longest = 1;

        for (int i = 1; i < N; ++i) {
            if (nums[i - 1] < nums[i]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }

            longest = Math.max(longest, dp[i]);
        }

        return longest;
    }
}
