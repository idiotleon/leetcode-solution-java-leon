/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * 
 * Time Complexity:     O(2 * N) ~ O(N)
 * Space Complexity:    O(N)
 */
package com.zea7ot.lc.lvl3.lc0238;

public class SolutionApproach0TwoPasses {
    public int[] productExceptSelf(int[] nums) {
        // sanity cehck
        if(nums == null || nums.length == 0) return new int[0];
        
        final int N = nums.length;
        int[] ans = new int[N];
        ans[0] = 1;
        for(int i = 1; i < N; i++){
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        
        int R = 1;
        for(int i = N - 1; i >= 0; i--){
            ans[i] *= R;
            R *= nums[i];
        }
        
        return ans;
    }
}