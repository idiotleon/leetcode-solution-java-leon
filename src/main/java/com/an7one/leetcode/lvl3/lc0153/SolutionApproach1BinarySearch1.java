/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl3.lc0153;

public class SolutionApproach1BinarySearch1 {
    public int findMin(int[] nums) {
        // sanity check
        if (nums.length == 0)
            return -1;

        final int N = nums.length;
        int lo = 0, hi = N - 1;
        if (nums[lo] <= nums[hi])
            return nums[lo];

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            if (nums[mid - 1] > nums[mid])
                return nums[mid];

            if (nums[lo] < nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return nums[lo];
    }
}