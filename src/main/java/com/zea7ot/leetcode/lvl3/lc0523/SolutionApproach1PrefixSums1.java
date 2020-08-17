/**
 * https://leetcode.com/problems/continuous-subarray-sum/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/continuous-subarray-sum/discuss/99518/Not-smart-solution-but-easy-to-understand
 */
package com.zea7ot.leetcode.lvl3.lc0523;

public class SolutionApproach1PrefixSums1 {
    public boolean checkSubarraySum(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length < 2)
            return false;

        final int N = nums.length;
        int[] prefixSums = new int[N + 1];

        for (int i = 1; i <= N; ++i)
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];

        for (int i = 0; i < N; ++i) {
            for (int j = i + 2; j <= N; ++j) {
                if (k == 0) {
                    if (prefixSums[j] - prefixSums[i] == 0)
                        return true;
                } else if ((prefixSums[j] - prefixSums[i]) % k == 0)
                    return true;
            }
        }

        return false;
    }
}