/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * Because that there are possibly negative numbers and 0(s), 
 *  the maximum product must come from either the previous minimum product(containing odd number of negative numbers) or the maximum product times the current value. 
 *  And then to compare the current value to get the current minimum or maximum product.
 *  Please note that do NOT involve any divide operation, because there might be a zero in the array, which costs extra code.
 */
package com.zea7ot.leetcode.lvl3.lc0152;

public class SolutionApproach0DP0Dimen {
    public int maxProduct(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        int maxProduct = Integer.MIN_VALUE;
        int prevMin = 1, prevMax = 1;

        for (int num : nums) {
            int curMin = Math.min(num, Math.min(num * prevMin, num * prevMax));
            int curMax = Math.max(num, Math.max(num * prevMin, num * prevMax));

            maxProduct = Math.max(maxProduct, curMax);

            prevMin = curMin;
            prevMax = curMax;
        }

        return maxProduct;
    }
}