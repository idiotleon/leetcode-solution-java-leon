/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * 
 * Because that there are possibly negative numbers and 0(s), 
 * the maximum product must come from either the previous minimum product(containing odd number of negative numbers) or the maximum product times the current value. 
 * And then to compare the current value to get the current minimum or maximum product.
 * Please note that do NOT involve any divide operation, because there might be a zero in the array, which costs extra code.
 */
package com.zea7ot.lc.lvl3.lc0152;

public class SolutionApproachOnePass {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int minProduct = 1, maxProduct = 1;
        
        for(int i = 0; i < nums.length; i++){
            int curMin = Math.min(nums[i], Math.min(nums[i] * minProduct, nums[i] * maxProduct));
            int curMax = Math.max(nums[i], Math.max(nums[i] * minProduct, nums[i] * maxProduct));
            
            minProduct = curMin;
            maxProduct = curMax;
            
            ans = Math.max(ans, maxProduct);
        }
        
        return ans;
    }
}