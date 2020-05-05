/**
 * https://leetcode.com/problems/subarray-product-less-than-k/
 * 
 * Time Complexity: O(N)
 */
package com.polyg7ot.lc.lvl3.lc0713;

public class SolutionApproachSlidingWindow {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return 0;
        int count = 0;
        int pro = 1;
        for(int i = 0, j = 0; j < nums.length; j++){
            pro *= nums[j];
            while(i <= j && pro >= k){
                pro /= nums[i++];
            }
            
            count += j - i + 1;
        }
        
        return count;
    }
}