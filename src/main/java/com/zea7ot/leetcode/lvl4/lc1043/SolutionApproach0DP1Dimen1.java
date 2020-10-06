/**
 * https://leetcode.com/problems/partition-array-for-maximum-sum/
 * 
 * Time Complexity:     O(N * K)
 * Space Complexity:    O(N)
 * 
 * `dp[i]`, max sum of (nums[1] ~ nums[i])
 * 
 * Transition
 * dp[i] = max{dp[i - k] + k * max(nums[i - (k - 1) ~ i])}, 1 <= k <= min(i, K)
 * 
 * Answer: dp[N]
 * 
 * References:
 *  https://leetcode.com/problems/partition-array-for-maximum-sum/discuss/290863/JavaC%2B%2BPython-DP
 */
package com.zea7ot.leetcode.lvl4.lc1043;

public class SolutionApproach0DP1Dimen1 {
    public int maxSumAfterPartitioning(int[] nums, int K) {
        // sanity check
        if (nums == null || nums.length < K)
            return 0;

        final int N = nums.length;
        int[] dp = new int[N];
        for (int i = 0; i < N; ++i) {
            int curMax = 0;
            for (int k = 1; k <= K && i - (k - 1) >= 0; ++k) {
                curMax = Math.max(curMax, nums[i - (k - 1)]);
                dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + curMax * k);
            }
        }

        return dp[N - 1];
    }
}