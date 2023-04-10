/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/max-consecutive-ones-iii/discuss/248287/java-sliding-windows-with-comments-in-line
 */
package com.idiotleon.leetcode.lvl3.lc1004;

public class SolutionApproach0SlidingWindow {
     public int longestOnes(int[] nums, int K) {
        // sanity check
        if (nums == null || nums.length < K || K < 0)
            return 0;

        final int N = nums.length;

        int lo = 0, hi = 0;
        int longest = 0;
        while (hi < N) {
            if (nums[hi] == 0)
                --K;

            if (K < 0) {
                while (nums[lo] != 0)
                    ++lo;

                ++lo;
                ++K;
            }

            longest = Math.max(longest, hi - lo + 1);
            ++hi;
        }

        return longest;
    }
}