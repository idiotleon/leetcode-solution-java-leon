/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * 
 * Time Complexity:     O(lg(N)), O(N) in the worst case
 * Space Complexity:    O(lg(N))
 * 
 * References:
 *  http://zxi.mytechroad.com/blog/divide-and-conquer/leetcode-154-find-minimum-in-rotated-sorted-array-ii/
 *  https://www.youtube.com/watch?v=aCb1zKMimDQ
 */
package com.idiotleon.leetcode.lvl4.lc0154;

public class SolutionApproach0DivideAndConquer {
    public int findMin(int[] nums) {
        final int N = nums.length;
        return findMin(0, N - 1, nums);
    }

    private int findMin(int lo, int hi, int[] nums) {
        // one or two elements only
        if (lo + 1 >= hi)
            return Math.min(nums[lo], nums[hi]);

        // this segment of the array is sorted
        if (nums[lo] < nums[hi])
            return nums[lo];

        int mid = lo + (hi - lo) / 2;

        return Math.min(findMin(lo, mid - 1, nums), findMin(mid, hi, nums));
    }
}