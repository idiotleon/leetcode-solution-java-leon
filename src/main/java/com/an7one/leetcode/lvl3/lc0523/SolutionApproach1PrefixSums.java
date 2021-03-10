/**
 * https://leetcode.com/problems/continuous-subarray-sum/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/continuous-subarray-sum/discuss/99518/Not-smart-solution-but-easy-to-understand/307737
 */
package com.an7one.leetcode.lvl3.lc0523;

public class SolutionApproach1PrefixSums {
    public boolean checkSubarraySum(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length < 2)
            return false;

        final int N = nums.length;
        for (int i = 0; i < N - 1; ++i) {
            int sum = nums[i];
            for (int j = i + 1; j < N; ++j) {
                sum += nums[j];
                if ((k == 0 && sum == 0) || (k != 0 && sum % k == 0))
                    return true;
            }
        }

        return false;
    }
}