package com.an7one.leetcode.lvl2.lc0209;

import com.an7one.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">LC0209</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-substring-problems>Leetcode</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0SlidingWindow {
    public int minSubArrayLen(int s, int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int shortest = Integer.MAX_VALUE;
        int sum = 0;
        int lo = 0, hi = 0;
        while (hi < N) {
            sum += nums[hi];
            while (sum >= s) {
                shortest = Math.min(shortest, hi - lo + 1);
                sum -= nums[lo];
                ++lo;
            }

            ++hi;
        }

        return shortest == Integer.MAX_VALUE ? 0 : shortest;
    }
}
