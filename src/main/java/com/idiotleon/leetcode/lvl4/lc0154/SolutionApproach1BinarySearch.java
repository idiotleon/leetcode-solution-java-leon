/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/discuss/167981/Beats-100-Binary-Search-with-Explanations
 */
package com.idiotleon.leetcode.lvl4.lc0154;

public class SolutionApproach1BinarySearch {
    public int findMin(int[] nums) {
        final int N = nums.length;

        int lo = 0, hi = N - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else if (nums[mid] < nums[lo]) {
                hi = mid;
                ++lo;
            } else {
                --hi;
            }
        }

        return nums[lo];
    }
}