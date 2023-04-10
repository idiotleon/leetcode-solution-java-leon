package com.idiotleon.leetcode.lvl2.lc0704;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/binary-search/">LC0704</a>
 * <p>
 * Time Complexity: O(lg(N))
 * Space Complexity: O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BinarySearch {
    public int search(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0) return -1;
        final int L = nums.length;
        int lo = 0, hi = L - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }

        return -1;
    }
}