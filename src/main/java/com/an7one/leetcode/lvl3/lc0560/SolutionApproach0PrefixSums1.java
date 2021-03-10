/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.an7one.leetcode.lvl3.lc0560;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0PrefixSums1 {
    public int subarraySum(int[] nums, final int K) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        Map<Integer, Integer> prefixSums = new HashMap<>();

        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;

            if (sum == K)
                ++count;
            if (prefixSums.containsKey(sum - K))
                count += prefixSums.get(sum - K);

            prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);

        }

        return count;
    }
}