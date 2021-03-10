/**
 * https://leetcode.com/problems/merge-sorted-array/
 * 
 * Time Complexity:     O(m + n)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl1.lc0088;

public class SolutionApproach0ThreePointers {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}