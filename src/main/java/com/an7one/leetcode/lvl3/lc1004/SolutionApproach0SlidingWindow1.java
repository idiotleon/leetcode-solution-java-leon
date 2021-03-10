/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/max-consecutive-ones-iii/discuss/247564/JavaC%2B%2BPython-Sliding-Window
 */
package com.an7one.leetcode.lvl3.lc1004;

public class SolutionApproach0SlidingWindow1 {
    public int longestOnes(int[] nums, int K) {
        // sanity check
        if (nums == null || nums.length < K || K < 0)
            return 0;

        final int N = nums.length;
        int lo = 0, hi = 0;

        while (hi < N) {
            if (nums[hi++] == 0)
                --K;

            if (K < 0 && nums[lo++] == 0)
                ++K;
        }

        return hi - lo;
    }
}