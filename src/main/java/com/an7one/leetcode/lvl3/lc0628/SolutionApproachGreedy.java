/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 * 
 * Time Complexity: O(Nlg(N))
 * Space Complexity: O(1)
 */
package com.an7one.leetcode.lvl3.lc0628;

import java.util.Arrays;

public class SolutionApproachGreedy {
    public int maximumProduct(int[] nums) {
        final int N = nums.length;
        Arrays.sort(nums);
        
        int sum = nums[N - 1] * nums[N - 2] * nums[N - 3];
        if(nums[1] >= 0){
            return sum;
        }else{
            return Math.max(sum, nums[0] * nums[1] * nums[N - 1]);
        }
    }
}