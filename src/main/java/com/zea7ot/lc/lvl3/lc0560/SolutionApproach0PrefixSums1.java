/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.zea7ot.lc.lvl3.lc0560;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0PrefixSums1 {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> prefixSums = new HashMap<Integer, Integer>();

        for (int num : nums) {
            sum += num;

            if (sum == k)
                ++count;

            if (prefixSums.containsKey(sum - k))
                count += prefixSums.get(sum - k);

            prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}