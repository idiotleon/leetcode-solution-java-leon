package com.an7one.leetcode.lvl1.lc0027;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/remove-element/
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int lo = 0;
        for (int hi = 0; hi < N; ++hi) {
            if (nums[hi] != val)
                nums[lo++] = nums[hi];
        }

        return lo;
    }
}