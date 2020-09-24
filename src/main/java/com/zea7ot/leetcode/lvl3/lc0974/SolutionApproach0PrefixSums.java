/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(K)
 * 
 * If sum[0, i] % K == sum[0, j] % K, sum[i + 1, j] is divisible by by K.
 * So for current index j, we need to find out how many index i (i < j) exit 
 * that has the same mod of K.
 * 
 * 
 * References:
 *  https://leetcode.com/problems/subarray-sums-divisible-by-k/discuss/217980/Java-O(N)-with-HashMap-and-prefix-Sum
 */
package com.zea7ot.leetcode.lvl3.lc0974;

public class SolutionApproach0PrefixSums {
    public int subarraysDivByK(int[] nums, int K) {
        final int[] PREFIX_SUMS = new int[K];
        PREFIX_SUMS[0] = 1;

        int count = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            sum %= K;

            if (sum < 0)
                sum += K;

            count += PREFIX_SUMS[sum];
            // if the sum of nums[i:j], and sum[0:j] - sum[0: i - 1], have the same
            // remainder
            ++PREFIX_SUMS[sum];
        }

        return count;
    }
}