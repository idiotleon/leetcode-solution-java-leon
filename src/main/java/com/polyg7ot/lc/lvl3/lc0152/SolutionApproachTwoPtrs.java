/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
package com.polyg7ot.lc.lvl3.lc0152;

public class SolutionApproachTwoPtrs {
    public int maxProduct(int[] nums) {
        final int N = nums.length;
        int res = nums[0], left = 0, right = 0;
        
        for(int i = 0; i < N; i++){
            left = (left == 0 ? 1 : left) * nums[i];
            right = (right == 0 ? 1 : right) * nums[N - 1 - i];
            res = Math.max(res, Math.max(left, right));
        }
        
        return res;
    }
}