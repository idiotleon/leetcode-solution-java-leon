package com.idiotleon.leetcode.lvl2.lc0283;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/">LC0283</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0HighLowPointers2 {
    public void moveZeroes(int[] nums) {
        // sanity check
        if (nums == null || nums.length < 2) {
            return;
        }

        final int N = nums.length;
        int lo = 0, hi = 0;

        while (hi < N) {
            while (hi < N && nums[hi] == 0) {
                ++hi;
            }

            if (hi < N) {
                swap(lo, hi, nums);
            }
            ++lo;
            ++hi;
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}