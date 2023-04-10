package com.idiotleon.leetcode.lvl2.lc0209;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">LC0209</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0SlidingWindow1 {
    public int minSubArrayLen1(int s, int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int sum = 0, len = 0;
        int shortest = Integer.MAX_VALUE;
        for (int hi = 0, lo = 0; hi < N; ++hi) {
            sum += nums[hi];
            ++len;
            if (sum >= s) {
                while (lo < hi && sum - nums[lo] >= s) {
                    sum -= nums[lo];
                    --len;
                    ++lo;
                }
                shortest = Math.min(shortest, len);
            }
        }

        if (sum < s)
            return 0;

        return shortest;
    }
}
