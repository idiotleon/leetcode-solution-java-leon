package com.an7one.leetcode.lvl1.lc0977;

import com.an7one.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">Description</a>
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0HighLowPointers1 {
    public int[] sortedSquares(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return new int[0];

        final int L = nums.length;
        int[] ans = new int[L];

        int lo = 0, hi = 0, idx = 0;
        while (hi < L && nums[hi] <= 0) {
            ++hi;
        }

        lo = hi - 1;

        while (idx < L) {
            if (lo >= 0 && hi < L) {
                if (Math.abs(nums[lo]) > Math.abs(nums[hi])) {
                    ans[idx++] = nums[hi] * nums[hi];
                    hi++;
                } else {
                    ans[idx++] = nums[lo] * nums[lo];
                    lo--;
                }
            } else if (lo >= 0) {
                ans[idx++] = nums[lo] * nums[lo];
                --lo;
            } else {
                ans[idx++] = nums[hi] * nums[hi];
                ++hi;
            }
        }

        return ans;
    }
}