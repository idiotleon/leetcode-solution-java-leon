/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(lg(N))
 */
package com.zea7ot.leetcode.lvl2.lc0053;

public class SolutionApproach1DivideAndConquer {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }
    
    private int maxSubArray(int[] nums, int left, int right){
        if(left > right) return Integer.MIN_VALUE;
        
        int mid = left + (right - left) / 2;
        int leftMax = maxSubArray(nums, left, mid - 1);
        int rightMax = maxSubArray(nums, mid + 1, right);
        
        int sum1 = 0, sum2 = 0;
        
        for(int i = mid - 1, cur = 0; i >= left; i--){
            cur += nums[i];
            sum1 = Math.max(sum1, cur);
        }
        
        for(int i = mid + 1, cur = 0; i <= right; i++){
            cur += nums[i];
            sum2 = Math.max(sum2, cur);
        }
        
        return Math.max(sum1 + sum2 + nums[mid], Math.max(leftMax, rightMax));
    }
}