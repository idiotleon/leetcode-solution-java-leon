package com.idiotleon.leetcode.lvl2.lc0283;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/">LC0283</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0HighLowPointers {
    public void moveZeroes(int[] nums) {
        // sanity check
        if (nums == null || nums.length < 2) {
            return;
        }


        final int N = nums.length;
        int lo = 0, hi = 0;

        while (hi < N) {
            if (hi < N && nums[hi] != 0) {
                nums[lo++] = nums[hi];
            }

            ++hi;
        }

        while (lo < N) {
            nums[lo++] = 0;
        }
    }
}