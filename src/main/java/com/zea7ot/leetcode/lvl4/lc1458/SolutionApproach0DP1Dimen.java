/**
 * https://leetcode.com/problems/max-dot-product-of-two-subsequences/
 * 
 * Time Complexity:     O(N1 * N2)
 * Space Complexity:    O(N2)
 * 
 * References:
 *  https://leetcode.com/problems/max-dot-product-of-two-subsequences/discuss/649858/JavaPython-3-2-Clean-DP-codes-of-O(mn)-and-O(min(m-n))-space-w-breif-explanation-and-analysis.
 */
package com.zea7ot.leetcode.lvl4.lc1458;

public class SolutionApproach0DP1Dimen {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        final int N1 = nums1.length, N2 = nums2.length;
        if (N1 < N2)
            return maxDotProduct(nums2, nums1);

        int[] dp = new int[N2 + 1];

        int largest = Integer.MIN_VALUE;

        for (int num1 : nums1) {
            int prevRowPrevCol = 0, prevCol = 0;
            for (int idx = 0; idx < N2; ++idx) {
                int product = num1 * nums2[idx];
                largest = Math.max(largest, product);
                product = Math.max(0, product);
                prevRowPrevCol = prevCol;
                prevCol = dp[idx + 1];
                dp[idx + 1] = Math.max(prevRowPrevCol + product, Math.max(dp[idx], dp[idx + 1]));
            }
        }

        return largest <= 0 ? largest : dp[N2];
    }
}
