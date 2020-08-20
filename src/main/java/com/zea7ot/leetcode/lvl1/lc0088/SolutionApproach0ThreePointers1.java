/**
 * https://leetcode.com/problems/merge-sorted-array/
 * 
 * Time Complexity:     O(m + n)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl1.lc0088;

public class SolutionApproach0ThreePointers1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        final int N = m + n;

        int idx = N - 1, idx1 = m - 1, idx2 = n - 1;

        while (idx >= 0) {
            int num1 = idx1 < 0 ? Integer.MIN_VALUE : nums1[idx1];
            int num2 = idx2 < 0 ? Integer.MIN_VALUE : nums2[idx2];

            if (num1 > num2) {
                nums1[idx--] = num1;
                --idx1;
            } else {
                nums1[idx--] = num2;
                --idx2;
            }

            // --idx;
        }
    }
}