/**
 * https://leetcode.com/problems/find-peak-element/
 * <p>
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(lg(N))
 * <p>
 * References:
 * https://zxi.mytechroad.com/blog/algorithms/binary-search/%E8%8A%B1%E8%8A%B1%E9%85%B1-leetcode-162-find-peak-element/
 */
package com.idiotleon.leetcode.lvl3.lc0162;

import com.idiotleon.util.Constant;

@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BinarySearch {
    public int findPeakElement(int[] nums) {
        // sanity check
        if (nums == null || nums.length < 2) return 0;

        final int N = nums.length;

        int lo = 0, hi = N - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] < nums[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}