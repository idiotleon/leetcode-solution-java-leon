/**
 * https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/discuss/279221/JavaPython-3-two-easy-DP-codes-w-comment-time-O(n)-NO-change-of-input
 *  https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/discuss/355352/Full-Explanation-and-idea-formation.-JAVA-beat-99
 */
package com.an7one.leetcode.lvl3.lc1031;

public class SolutionApproach0SlidingWindow {
    public int maxSumTwoNoOverlap(int[] nums, int L, int M) {
        return Math.max(maxSum(nums, L, M), maxSum(nums, M, L));
    }

    private int maxSum(int[] nums, int L, int M) {
        final int N = nums.length;

        int sumL = 0, sumM = 0;
        // to compute the initial values of subarrays of length L & M
        for (int i = 0; i < L + M; ++i) {
            if (i < L)
                sumL += nums[i];
            else
                sumM += nums[i];
        }

        int ans = sumM + sumL; // sum of `sumL` and `sumM`
        for (int i = L + M, maxL = sumL; i < N; ++i) {
            sumM += nums[i] - nums[i - M]; // to update `sumM`
            sumL += nums[i - M] - nums[i - L - M]; // to update `sumL`
            maxL = Math.max(maxL, sumL); // to update the max value of subarray of length L
            ans = Math.max(ans, maxL + sumM); // to update the max value of the sum of subarrays of length L & M
        }

        return ans;
    }
}