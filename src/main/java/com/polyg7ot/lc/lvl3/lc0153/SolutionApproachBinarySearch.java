/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
package com.polyg7ot.lc.lvl3.lc0153;

public class SolutionApproachBinarySearch {
    public int findMin(int[] nums) {
        // sanity check
        if (nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[left])
            return nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            if (nums[mid - 1] > nums[mid])
                return nums[mid];

            if (nums[left] < nums[mid])
                left = mid + 1;
            else
                right = mid;
        }

        return nums[left];
    }
}