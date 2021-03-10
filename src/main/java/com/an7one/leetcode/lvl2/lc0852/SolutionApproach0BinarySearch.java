/**
 * @author: Leon
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl2.lc0852;

public class SolutionApproach0BinarySearch {
    public int peakIndexInMountainArray(int[] nums) {
        // sanity check
        if (nums == null || nums.length < 3)
            return 0;

        final int N = nums.length;

        int lo = 1, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid - 1] > nums[mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        return lo;
    }
}