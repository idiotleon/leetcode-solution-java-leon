/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
package com.null7ptr.lc.lvl3.lc0238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        for(int i = 1; i < len; i++){
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        
        int R = 1;
        for(int i = len - 1; i >= 0; i--){
            ans[i] *= R;
            R *= nums[i];
        }
        
        return ans;
    }
}