/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 
 * Time Complexity: O(lg(N))
 *  in the worst case: O(N)
 *  e.g.: [1,1,1,1,1,1,5], target = 5
 * Space Complexity: O(1)
 */
package com.an7one.leetcode.lvl4.lc0081;

public class SolutionApproach0BinarySearch1 {
    public boolean search(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0)
            return false;

        final int N = nums.length;
        int lo = 0, hi = N - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target)
                return true;

            if (nums[mid] == nums[lo])
                lo++;
            else if (nums[mid] > nums[lo]) {
                if (nums[mid] > target && nums[lo] <= target) {
                    hi = mid;
                } else
                    lo = mid + 1;
            } else {
                if (nums[mid] < target && nums[hi] >= target) {
                    lo = mid + 1;
                } else
                    hi = mid;
            }
        }

        return false;
    }
}