/**
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N ^ 2)
 * 
 * dp[i][j] represents the longest fibonacci subsequence ending with `nums[i]` and `nums[j]`
 * dp[i][j] = (dp[j - i][i] + 1) or 2
 * 
 * References:
 *  https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/discuss/165330/Java-beat-98-DP-%2B-2Sum
 */
package com.idiotleon.leetcode.lvl3.lc0873;

public class SolutionApproach0DP2Dimen {
    public int lenLongestFibSubseq(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[][] dp = new int[N][N];
        int longest = 0;

        for (int i = 2; i < N; ++i) {
            int target = nums[i];
            int lo = 0, hi = i - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (sum > target)
                    --hi;
                else if (sum < target)
                    ++lo;
                else {
                    dp[hi][i] = dp[lo][hi] + 1;
                    longest = Math.max(longest, dp[hi][i]);
                    --hi;
                    ++lo;
                }
            }
        }

        return longest == 0 ? 0 : longest + 2;
    }
}