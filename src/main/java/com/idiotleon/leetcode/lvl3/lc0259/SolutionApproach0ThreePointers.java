package com.idiotleon.leetcode.lvl3.lc0259;

import com.idiotleon.util.Constant;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/3sum-smaller/">LC0259</a>
 * <p>
 * Time Complexity:     O(`N` * lg(`N`)) + O(`N` ^ 2) ~ O(`N` ^ 2)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0ThreePointers {
    public int threeSumSmaller(int[] nums, int target) {
        int ans = 0;
        // sanity check
        if (nums == null || nums.length == 0) {
            return ans;
        }

        final int N = nums.length;
        Arrays.sort(nums);

        for (int lo = 0; lo < N - 2; ++lo) {
            int mid = lo + 1, hi = N - 1;
            while (mid < hi) {
                final int sum = nums[lo] + nums[mid] + nums[hi];

                if (sum < target) {
                    ans += hi - mid;
                    ++mid;
                } else {
                    --hi;
                }
            }
        }

        return ans;
    }
}