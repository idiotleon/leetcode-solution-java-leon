/**
 * https://leetcode.com/problems/max-dot-product-of-two-subsequences/
 * 
 * Time Complexity:     O(N1 * N2)
 * Space Complexity:    O(N1 * N2)
 * 
 * References:
 *  https://leetcode.com/problems/max-dot-product-of-two-subsequences/discuss/649858/JavaPython-3-2-Clean-DP-codes-of-O(mn)-and-O(min(m-n))-space-w-breif-explanation-and-analysis.
 */
package com.idiotleon.leetcode.lvl4.lc1458;

public class SolutionApproach0DP2Dimen {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        final int N1 = nums1.length, N2 = nums2.length;
        int[][] dp = new int[N1 + 1][N2 + 1];

        int largest = Integer.MIN_VALUE;

        for (int idx1 = 0; idx1 < N1; ++idx1) {
            for (int idx2 = 0; idx2 < N2; ++idx2) {
                int product = nums1[idx1] * nums2[idx2];
                largest = Math.max(largest, product);
                product = Math.max(0, product);
                dp[idx1 + 1][idx2 + 1] = Math.max(dp[idx1][idx2] + product,
                        Math.max(dp[idx1 + 1][idx2], dp[idx1][idx2 + 1]));
            }
        }

        return largest <= 0 ? largest : dp[N1][N2];
    }
}
