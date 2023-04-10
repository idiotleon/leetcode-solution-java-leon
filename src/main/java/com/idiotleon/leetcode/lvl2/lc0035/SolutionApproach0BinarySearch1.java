/**
 * https://leetcode.com/problems/search-insert-position/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl2.lc0035;

public class SolutionApproach0BinarySearch1 {
    public int searchInsert(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int lo = 0, hi = N - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target)
                return mid;
            if (target < nums[mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        return lo;
    }
}