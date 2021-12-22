/**
 * https://leetcode.com/problems/find-peak-element/
 * <p>
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(lg(N))
 */
package com.an7one.leetcode.lvl3.lc0162;

import com.an7one.util.Constant;

@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BinarySearchRecursive {
    public int findPeakElement(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0) return 0;

        final int N = nums.length;
        return search(0, N - 1, nums);
    }

    private int search(int lo, int hi, int[] nums) {
        if (lo == hi) return lo;

        int mid = lo + (hi - lo) / 2;
        if (nums[mid] > nums[mid + 1]) return search(lo, mid, nums);
        else return search(mid + 1, hi, nums);
    }
}