/**
 * https://leetcode.com/problems/search-insert-position/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0035;

public class SolutionApproach0BinarySearch {
    public int searchInsert(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int lo = 0, hi = N;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }
}