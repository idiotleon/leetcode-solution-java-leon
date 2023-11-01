package com.idiotleon.leetcode.lvl3.lc0033;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">LC0033</a>
 * <p>
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1BinarySearch {
    public int search2(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0) {
            return -1;
        }

        final int N = nums.length;
        int lo = 0, hi = N - 1;

        while (lo < hi) {
            final int mid = lo + (hi - lo) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target <= nums[mid]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
        }

        return nums[lo] == target ? lo : -1;
    }
}