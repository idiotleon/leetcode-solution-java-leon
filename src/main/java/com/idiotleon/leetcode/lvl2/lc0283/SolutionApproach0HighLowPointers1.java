package com.idiotleon.leetcode.lvl2.lc0283;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/">LC0283</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0HighLowPointers1 {
    public void moveZeroes(final int[] nums) {
        // sanity check
        if (nums == null || nums.length < 2) {
            return;
        }

        final int N = nums.length;
        int lo = 0;

        for (int hi = 0; hi < N; ++hi) {
            if (nums[hi] != 0) {
                nums[lo++] = nums[hi];
            }
        }

        while (lo < N) {
            nums[lo++] = 0;
        }
    }
}