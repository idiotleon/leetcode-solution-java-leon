/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * Time Complexity:     O(lg(N))
 *  T(N) = T(N / 2) + O(1) = T(lg(N)), NOT T(N) = 2 * T(N / 2) = O(N)
 * 
 * Space Complexity:    O(lg(N))
 * 
 * References:
 *  http://zxi.mytechroad.com/blog/divide-and-conquer/leetcode-153-find-minimum-in-rotated-sorted-array/
 *  https://www.youtube.com/watch?v=P4r7mF1Jd50
 */
package com.zea7ot.leetcode.lvl3.lc0153;

public class SolutionApproach0DivideAndConquer {
    public int findMin(int[] nums) {
        final int N = nums.length;
        return findMin(0, N - 1, nums);
    }

    private int findMin(int lo, int hi, int[] nums) {
        // only 1 or 2 elements
        if (lo + 1 >= hi)
            return Math.min(nums[lo], nums[hi]);

        // this segment of the array is sorted
        if (nums[lo] < nums[hi])
            return nums[lo];

        int mid = lo + (hi - lo) / 2;

        return Math.min(findMin(lo, mid - 1, nums), findMin(mid, hi, nums));
    }
}