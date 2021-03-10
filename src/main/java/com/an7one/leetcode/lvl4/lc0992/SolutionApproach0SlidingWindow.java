/**
 * https://leetcode.com/problems/subarrays-with-k-different-integers/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * 
 * References:
 *  https://leetcode.com/problems/subarrays-with-k-different-integers/discuss/523136/JavaC%2B%2BPython-Sliding-Window
 *  https://leetcode.com/problems/subarrays-with-k-different-integers/discuss/523136/JavaC++Python-Sliding-Window/556706
 *  https://leetcode.com/problems/subarrays-with-k-different-integers/discuss/235002/One-code-template-to-solve-all-of-these-problems!
 */
package com.an7one.leetcode.lvl4.lc0992;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0SlidingWindow {
    public int subarraysWithKDistinct(int[] nums, int K) {
        // sanity check
        if (nums == null || nums.length < K || K <= 0)
            return 0;

        return atMostK(K, nums) - atMostK(K - 1, nums);
    }

    private int atMostK(int K, int[] nums) {
        final int N = nums.length;
        int lo = 0, hi = 0;
        int count = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        while (hi < N) {
            freq.put(nums[hi], freq.getOrDefault(nums[hi], 0) + 1);

            while (freq.size() > K) {
                freq.put(nums[lo], freq.get(nums[lo]) - 1);
                freq.remove(nums[lo], 0);
                ++lo;

            }

            count += hi - lo + 1;
            ++hi;
        }

        return count;
    }
}