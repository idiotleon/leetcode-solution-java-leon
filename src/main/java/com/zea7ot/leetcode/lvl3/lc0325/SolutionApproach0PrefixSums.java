/**
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/discuss/77778/Java-O(n)-explain-how-I-come-up-with-this-idea/82048
 *  https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/discuss/77778/Java-O(n)-explain-how-I-come-up-with-this-idea
 */
package com.zea7ot.leetcode.lvl3.lc0325;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0PrefixSums {
    public int maxSubArrayLen(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int sum = 0, longest = 0;
        final Map<Integer, Integer> PREFIX_SUMS = new HashMap<>();
        // to make sum from 0 to j consistent
        PREFIX_SUMS.put(0, -1);

        for (int i = 0; i < N; ++i) {
            sum += nums[i];

            if (PREFIX_SUMS.containsKey(sum - k)) {
                final int LEN = i - PREFIX_SUMS.get(sum - k);
                longest = Math.max(longest, LEN);
            }

            // to only keep the 1st/ealiest index
            if (!PREFIX_SUMS.containsKey(sum)) {
                PREFIX_SUMS.put(sum, i);
            }
        }

        return longest;
    }
}