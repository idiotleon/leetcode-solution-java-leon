/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * Time Complexity:     O(lg(N1 + N2))
 * Space Complexity:    O(1)
 * 
 * References:
 *  http://bit.ly/2YUmy9F
 *  http://bit.ly/34uQudj 
 */
package com.zea7ot.lc.lvl4.lc0004;

public class SolutionApproach0DivideAndConquer {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int N1 = nums1.length, N2 = nums2.length;
        final int LEFT = (N1 + N2 + 1) / 2;
        final int RIGHT = (N1 + N2 + 2) / 2;

        // a trick here: 
        // even the number of total elements are odd, `getKthSmallest` will be executed twice
        return (getKthSmallest(0, N1 - 1, nums1, 0, N2 - 1, nums2, LEFT)
                + getKthSmallest(0, N1 - 1, nums1, 0, N2 - 1, nums2, RIGHT)) / 2.0;
    }

    private int getKthSmallest(int lo1, int hi1, int[] nums1, int lo2, int hi2, int[] nums2, int k) {
        final int LEN1 = hi1 - lo1 + 1;
        final int LEN2 = hi2 - lo2 + 1;

        if (LEN1 > LEN2)
            return getKthSmallest(lo2, hi2, nums2, lo1, hi1, nums1, k);
        if (LEN1 == 0)
            return nums2[lo2 + k - 1];

        if (k == 1)
            return Math.min(nums1[lo1], nums2[lo2]);

        int idx1 = lo1 + Math.min(LEN1, k / 2) - 1;
        int idx2 = lo2 + Math.min(LEN2, k / 2) - 1;

        if (nums1[idx1] > nums2[idx2])
            return getKthSmallest(lo1, hi1, nums1, idx2 + 1, hi2, nums2, k - (idx2 - lo2 + 1));
        else
            return getKthSmallest(idx1 + 1, hi1, nums1, lo2, hi2, nums2, k - (idx1 - lo1 + 1));
    }
}