/**
 * https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/discuss/279221/JavaPython-3-two-easy-DP-codes-w-comment-time-O(n)-NO-change-of-input
 *  https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/discuss/355352/Full-Explanation-and-idea-formation.-JAVA-beat-99
 */
package com.an7one.leetcode.lvl3.lc1031;

public class SolutionApproach0PrefixSums {
    public int maxSumTwoNoOverlap(int[] nums, int L, int M) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int[] prefixSums = new int[N + 1];
        for (int i = 0; i < N; i++)
            prefixSums[i + 1] = prefixSums[i] + nums[i];

        return Math.max(maxSum(prefixSums, L, M), maxSum(prefixSums, M, L));
    }

    private int maxSum(int[] prefixSums, final int L, final int M) {
        final int N = prefixSums.length;
        int max = 0;
        for (int i = L + M, maxL = 0; i < N; i++) {
            // to update the max value of the subarrays of length L
            maxL = Math.max(maxL, prefixSums[i - M] - prefixSums[i - M - L]);

            // to update the max value of the sum of subarrays of length L and M
            max = Math.max(max, maxL + prefixSums[i] - prefixSums[i - M]);
        }

        return max;
    }
}