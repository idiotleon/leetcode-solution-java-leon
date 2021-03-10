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
 *  https://www.youtube.com/watch?v=3M8q-wB2tmw
 *  https://leetcode.com/problems/partition-array-for-maximum-sum/discuss/290863/JavaC%2B%2BPython-DP
 */
package com.an7one.leetcode.lvl4.lc1043;

public class SolutionApproach0DP1Dimen {
    public int maxSumAfterPartitioning(int[] nums, int K) {
        // sanity check
        if (nums == null || nums.length < K)
            return 0;

        final int N = nums.length;
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            // the max partition
            int curMax = Integer.MIN_VALUE;
            for (int k = 1; k <= Math.min(i, K); ++k) {
                // to try the previous/last, to `nums[i]`, `k` position(s)
                curMax = Math.max(curMax, nums[i - k]);
                dp[i] = Math.max(dp[i], dp[i - k] + curMax * k);
            }
        }

        return dp[N];
    }
}