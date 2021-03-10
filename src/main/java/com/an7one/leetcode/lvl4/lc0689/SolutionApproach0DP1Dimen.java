/**
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * `dp[i]`, prefix sums with the sliding window of `k`
 * `left[i]`, the index of the max value, of `dp[i]`, from the left/start
 * `right[i]`, the index of the max value, of `dp[i]`, from the right/end
 * 
 * 
 * 
 * References:
 *  https://www.youtube.com/watch?v=dGS4O0110qA
 *  https://happygirlzt.com/code/689.html
 */
package com.an7one.leetcode.lvl4.lc0689;

public class SolutionApproach0DP1Dimen {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length < 3 * k)
            return new int[0];

        final int N = nums.length;
        final int K = N - k + 1;

        int[] dp = new int[K];
        int sum = 0;
        for (int i = 0; i < N; ++i) {
            sum += nums[i];
            if (i >= k)
                sum -= nums[i - k];

            if (i >= k - 1)
                dp[i - k + 1] = sum;
        }

        int[] left = new int[K];
        int maxIdx = 0;
        for (int i = 0; i < K; ++i) {
            if (dp[i] > dp[maxIdx])
                maxIdx = i;

            left[i] = maxIdx;
        }

        int[] right = new int[K];
        maxIdx = K - 1;
        for (int i = K - 1; i >= 0; --i) {
            if (dp[i] >= dp[maxIdx])
                maxIdx = i;

            right[i] = maxIdx;
        }

        int[] ans = { -1, -1, -1 };
        for (int i = k; i < K - k; ++i) {
            if (ans[0] == -1 || dp[ans[0]] + dp[ans[1]] + dp[ans[2]] < dp[left[i - k]] + dp[i] + dp[right[i + k]]) {
                ans[0] = left[i - k];
                ans[1] = i;
                ans[2] = right[i + k];
            }
        }

        return ans;
    }
}