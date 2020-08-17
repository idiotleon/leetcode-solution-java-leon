/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * Time Complexity:     O(lg(min(L1, L2)))
 * Space Complexity:    O(1)
 * 
 * to find such a partition (left and right parts, including both arrays):
 *  1. both parts have the same total elements
 *  2. every element on the left side is smaller or equal to the elements on the right side
 * 
 *  x -> x1 x2 | x3 x4 x5 x6
 *  y -> y1 y2 y3 y4 y5 | y6 y7 y8
 * 
 * if(x2 <= y6 && y5 <= x3), 
 *  to return avg(max(x2, y5), min(x3, y6)) if `L1 + L2` is even, or
 *  to return max(x2, y5), if `L1 + L2` is odd
 * 
 * 
 * 
 * References:
 *  https://www.youtube.com/watch?v=KB9IcSCDQ9k
 *  https://zxi.mytechroad.com/blog/algorithms/binary-search/leetcode-4-median-of-two-sorted-arrays/
 *  https://www.youtube.com/watch?v=LPFhl65R7ww
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
 */
package com.zea7ot.leetcode.lvl4.lc0004;

public class SolutionApproach0BinarySearch {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int N1 = nums1.length, N2 = nums2.length;

        if (N1 > N2)
            return findMedianSortedArrays(nums2, nums1);

        final int N = N1 + N2, MID = (N + 1) / 2;

        int lo = 0, hi = N1;
        while (lo < hi) {
            int mid1 = lo + (hi - lo) / 2;
            int mid2 = MID - mid1;
            // `nums1[mid1]`, the first element, in the 1st array, that is NOT taken
            // `nums2[mid2 - 1]`, the last element, in the 2nd array, that is taken
            if (nums1[mid1] < nums2[mid2 - 1])
                lo = mid1 + 1;
            else
                hi = mid1;
        }

        int mid1 = lo, mid2 = MID - lo;
        final int C1 = Math.max(mid1 <= 0 ? Integer.MIN_VALUE : nums1[mid1 - 1],
                mid2 <= 0 ? Integer.MIN_VALUE : nums2[mid2 - 1]);
        if (N % 2 == 1)
            return C1;

        final int C2 = Math.min(mid1 >= N1 ? Integer.MAX_VALUE : nums1[mid1],
                mid2 >= N2 ? Integer.MAX_VALUE : nums2[mid2]);

        return (C1 + C2) / 2.0;
    }
}