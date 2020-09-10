/**
 * https://leetcode.com/problems/continuous-subarray-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * the remainder theorem:
 *  (a+(n*x))%x is same as (a%x)
 * 
 * for the padding (0, -1):
 *  1. to return true when `runningSum % k == 0`
 *  2. to prevent early returns if `nums[0] % k == 0`
 * 
 * References:
 *  https://leetcode.com/problems/continuous-subarray-sum/discuss/99499/Java-O(n)-time-O(k)-space
 */
package com.zea7ot.leetcode.lvl3.lc0523;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0PrefixSums {
    public boolean checkSubarraySum(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length < 2)
            return false;

        final int N = nums.length;
        int runningSum = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, -1);

        for (int i = 0; i < N; ++i) {
            runningSum += nums[i];
            if (k != 0)
                runningSum %= k;
            if (prefixSums.containsKey(runningSum)) {
                int prevIdx = prefixSums.get(runningSum);
                if (i - prevIdx > 1)
                    return true;
            } else
                prefixSums.put(runningSum, i);
        }

        return false;
    }
}