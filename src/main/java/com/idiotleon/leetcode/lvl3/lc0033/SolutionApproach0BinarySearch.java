package com.idiotleon.leetcode.lvl3.lc0033;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">LC0033</a>
 * <p>
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BinarySearch {
    public int search(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0)
            return -1;

        final int N = nums.length;
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            final int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target)
                return mid;
            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else
                    lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else
                    hi = mid - 1;
            }
        }

        return -1;
    }
}