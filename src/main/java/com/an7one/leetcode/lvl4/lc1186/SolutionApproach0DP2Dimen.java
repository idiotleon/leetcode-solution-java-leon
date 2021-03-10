/**
 * https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * `dp[i][j]`
 *  j = 0, not deleted before
 *  j = 1, already deleted before
 * 
 * Reference:
 *  https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/discuss/377397/Intuitive-Java-Solution-With-Explanation/341104
 *  https://youtu.be/FLbqgyJ-70I?t=2381
 */
package com.an7one.leetcode.lvl4.lc1186;

public class SolutionApproach0DP2Dimen {
    public int maximumSum(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[][] dp = new int[N][2];
        // not deleted
        dp[0][0] = nums[0];
        // deleted
        dp[0][1] = 0;

        int maxSum = nums[0];
        for (int i = 1; i < N; ++i) {
            dp[i][0] = Math.max(nums[i], dp[i - 1][0] + nums[i]);
            dp[i][1] = Math.max(nums[i], Math.max(dp[i - 1][1] + nums[i], dp[i - 1][0]));

            maxSum = Math.max(maxSum, dp[i][0]);
            maxSum = Math.max(maxSum, dp[i][1]);
        }

        return maxSum;
    }
}