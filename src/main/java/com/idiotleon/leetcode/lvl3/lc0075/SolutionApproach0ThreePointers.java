package com.idiotleon.leetcode.lvl3.lc0075;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/sort-colors/">LC0075</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0ThreePointers {
    public void sortColors(int[] nums) {
        // sanity check
        if (nums == null || nums.length < 2)
            return;

        final int N = nums.length;
        int lo = 0, hi = N - 1;

        // slightly pruning
        while (lo < N && nums[lo] == 0) {
            ++lo;
        }
        while (hi >= 0 && nums[hi] == 2) {
            --hi;
        }

        int mid = lo;
        while (mid <= hi) {
            if (nums[mid] == 0)
                swap(mid++, lo++, nums);
            /**
             * 1. Conditions of if{...}if{...}if{...} is apparently different from
             * if{...}else if{...}else{...}. 2. After swapping "idx" and "hi", idx does not
             * increment. Otherwise, [...0,2,...] is slipped through.
             */
            else if (nums[mid] == 2)
                swap(mid, hi--, nums);
            else
                ++mid;
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}