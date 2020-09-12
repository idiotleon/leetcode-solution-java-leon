/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0560;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0PrefixSums1 {
    public int subarraySum(int[] nums, final int K) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final Map<Integer, Integer> PREFIX_SUMS = new HashMap<>();

        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;

            if (sum == K)
                ++count;
            if (PREFIX_SUMS.containsKey(sum - K))
                count += PREFIX_SUMS.get(sum - K);

            PREFIX_SUMS.put(sum, PREFIX_SUMS.getOrDefault(sum, 0) + 1);

        }

        return count;
    }
}