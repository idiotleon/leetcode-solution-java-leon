/**
 * https://leetcode.com/problems/3sum-with-multiplicity/
 *
 * Time Complexity:     O(`N` ^ 2) ~ O(101 ^ 2)
 * Space Complexity:    O(`N` ^ 2) ~ O(101 ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/3sum-with-multiplicity/discuss/181128/10-lines-Super-Super-Easy-Java-Solution
 */
package com.idiotleon.leetcode.lvl3.lc0923;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0FreqsMap {
    private static final int MOD = (int) 1e9 + 7;

    public int threeSumMulti(int[] nums, int target) {
        final int N = nums.length;

        Map<Integer, Integer> freqs = new HashMap<>();

        int count = 0;

        for (int hi = 0; hi < N; ++hi) {
            count += freqs.getOrDefault(target - nums[hi], 0) % MOD;
            count %= MOD;

            for (int lo = 0; lo < hi; ++lo) {
                int twoSum = nums[lo] + nums[hi];
                freqs.put(twoSum, freqs.getOrDefault(twoSum, 0) + 1);
            }
        }

        return count;
    }
}
