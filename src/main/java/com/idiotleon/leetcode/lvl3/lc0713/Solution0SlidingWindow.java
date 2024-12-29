package com.idiotleon.leetcode.lvl3.lc0713;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/subarray-product-less-than-k/">LC0713</a>
 * <p>
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class Solution0SlidingWindow {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return 0;
        }

        final int N = nums.length;

        int count = 0;
        int product = 1;

        int lo = 0, hi = 0;

        while (hi < N) {
            product *= nums[hi];

            while (lo <= hi && product >= k) {
                product /= nums[lo];
                ++lo;
            }

            count += hi - lo + 1;
            ++hi;
        }

        return count;
    }
}