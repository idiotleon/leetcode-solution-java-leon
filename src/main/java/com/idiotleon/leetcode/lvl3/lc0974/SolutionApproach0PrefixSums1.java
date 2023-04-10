/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * 
 * Time Complexity:     O(N)
 * Space Comlexity:     O(K)
 * 
 * If sum[0, i] % K == sum[0, j] % K, sum[i + 1, j] is divisible by by K.
 * So for current index j, we need to find out how many index i (i < j) exit 
 * that has the same mod of K.
 * 
 * References:
 *  https://leetcode.com/problems/subarray-sums-divisible-by-k/discuss/217980/Java-O(N)-with-HashMap-and-prefix-Sum
 */
package com.idiotleon.leetcode.lvl3.lc0974;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0PrefixSums1 {
    public int subarraysDivByK(int[] nums, int K) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        int count = 0, sum = 0;
        final Map<Integer, Integer> PREFIX_SUMS = new HashMap<>();
        PREFIX_SUMS.put(0, 1);

        for (int num : nums) {
            sum += num;
            sum %= K;

            // in cases -1 % 5 = -1,
            // while its positive mod is expected,
            // which is -1 + 5 = 4
            if (sum < 0)
                sum += K;

            count += PREFIX_SUMS.getOrDefault(sum, 0);
            PREFIX_SUMS.put(sum, PREFIX_SUMS.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}