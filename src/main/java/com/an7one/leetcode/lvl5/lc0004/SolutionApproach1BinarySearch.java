/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * Time Complexity:     O(lg(min(L1, L2)))
 * 
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/Very-concise-O(log(min(MN)))-iterative-solution-with-detailed-explanation
 */
package com.an7one.leetcode.lvl5.lc0004;

public class SolutionApproach1BinarySearch {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int N1 = nums1.length, N2 = nums2.length;
        // to make sure that nums1 is longer than nums2
        if (N1 < N2)
            return findMedianSortedArrays(nums2, nums1);

        int lo = 0, hi = 2 * N2;
        while (lo <= hi) {
            // to try to cur nums2
            int mid2 = lo + (hi - lo) / 2;
            // to calculate mid1 accordingly
            int mid1 = N1 + N2 - mid2;

            // to get left1, left2, right1, right2 respectively
            double left1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double left2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double right1 = (mid1 == N1 * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            double right2 = (mid2 == N2 * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];

            // loer half of nums1 is too big
            if (left1 > right2)
                lo = mid2 + 1;
            // loer half of nums2 is too big
            else if (left2 > right1)
                hi = mid2 - 1;
            else
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2;
        }

        return -1;
    }
}