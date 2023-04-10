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
 *  https://www.youtube.com/watch?v=LPFhl65R7ww
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
 *  https://www.youtube.com/watch?v=KB9IcSCDQ9k
 *  https://zxi.mytechroad.com/blog/algorithms/binary-search/leetcode-4-median-of-two-sorted-arrays/
 */
package com.idiotleon.leetcode.lvl5.lc0004;

public class SolutionApproach0BinarySearch1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int N1 = nums1.length, N2 = nums2.length;
        // to make sure that the `nums1` is the shorter one
        if (N1 > N2)
            return findMedianSortedArrays(nums2, nums1);

        int lo = 0, hi = N1;
        while (lo <= hi) {
            int mid1 = lo + (hi - lo) / 2;
            // both sides have the same total elements
            int mid2 = (N1 + N2 + 1) / 2 - mid1;

            int maxLeft1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int minRight1 = (mid1 == N1) ? Integer.MAX_VALUE : nums1[mid1];

            int maxLeft2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int minRight2 = (mid2 == N2) ? Integer.MAX_VALUE : nums2[mid2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((N1 + N2) % 2 == 0)
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                else
                    return Math.max(maxLeft1, maxLeft2);
            } else if (maxLeft1 > minRight2) { // too much on the left side
                hi = mid1 - 1; // to move to the left
            } else { // too much on the right side
                lo = mid1 + 1; // to move to the right
            }
        }

        return -1;
    }
}