/**
 * https://leetcode.com/problems/get-the-maximum-score/
 * 
 * Time Complexity:     O(N1 + N2)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/get-the-maximum-score/discuss/767987/JavaC%2B%2B-Two-Pointers-O(1)-Space
 */
package com.zea7ot.lc.lvl4.lc1537;

public class SolutionApproach0TwoPointers {
    public int maxSum(int[] nums1, int[] nums2) {
        final int N1 = nums1.length, N2 = nums2.length;
        final int MOD = (int) 1e9 + 7;

        int idx1 = 0, idx2 = 0;
        long path1 = 0, path2 = 0;
        long ans = 0;

        while (idx1 < N1 || idx2 < N2) {
            if (idx1 < N1 && (idx2 == N2 || nums1[idx1] < nums2[idx2])) {
                path1 += nums1[idx1++];
            } else if (idx2 < N2 && (idx1 == N1 || nums1[idx1] > nums2[idx2])) {
                path2 += nums2[idx2++];
            } else {
                ans += Math.max(path1, path2) + nums1[idx1];
                ++idx1;
                ++idx2;
                path1 = 0;
                path2 = 0;
            }
        }

        return (int) ((ans + Math.max(path1, path2)) % MOD);
    }
}