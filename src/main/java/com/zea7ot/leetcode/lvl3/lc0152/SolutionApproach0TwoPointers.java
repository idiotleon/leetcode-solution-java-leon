/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-product-subarray/discuss/183483/In-Python-it-can-be-more-concise-PythonC%2B%2BJava
 */
package com.zea7ot.leetcode.lvl3.lc0152;

public class SolutionApproach0TwoPointers {
    public int maxProduct(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int maxProduct = nums[0];
        int lo = 0, hi = 0;

        for (int i = 0; i < N; ++i) {
            lo = (lo == 0 ? 1 : lo) * nums[i];
            hi = (hi == 0 ? 1 : hi) * nums[N - 1 - i];
            
            maxProduct = Math.max(maxProduct, Math.max(lo, hi));
        }

        return maxProduct;
    }
}