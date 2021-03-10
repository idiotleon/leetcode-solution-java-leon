/**
 * https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 * 
 * Time Complexity:     O(2 * N) ~ O(N)
 * Space Complexity:    O(N)
 * 
 * the preSum approach applies situations where there are negative numbers.
 * the approach below requires 2 passes.
 * 
 * References:
 *  https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/discuss/685486/JAVA-O(N)-Time-Two-Pass-Solution-using-HashMap.
 */
package com.an7one.leetcode.lvl4.lc1477;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0PrefixSums1 {
    public int minSumOfLengths(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        Map<Integer, Integer> prefixSums = new HashMap<Integer, Integer>();
        prefixSums.put(0, -1);
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            prefixSums.put(sum, i);
        }

        sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            if (prefixSums.containsKey(sum - target)) {
                minLen = Math.min(minLen, i - prefixSums.get(sum - target));
            }

            if (prefixSums.containsKey(sum + target) && minLen != Integer.MAX_VALUE) {
                ans = Math.min(ans, prefixSums.get(sum + target) - i + minLen);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}