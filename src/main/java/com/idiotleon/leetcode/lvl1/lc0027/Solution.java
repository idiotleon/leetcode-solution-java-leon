package com.idiotleon.leetcode.lvl1.lc0027;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * https://leetcode.com/problems/remove-element/
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(1)
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