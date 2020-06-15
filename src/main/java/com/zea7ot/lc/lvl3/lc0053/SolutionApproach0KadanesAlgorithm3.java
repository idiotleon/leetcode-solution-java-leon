/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 *  Kadane's Algorithm
 *  https://hackernoon.com/kadanes-algorithm-explained-50316f4fd8a6
 */
package com.zea7ot.lc.lvl3.lc0053;

public class SolutionApproach0KadanesAlgorithm3{
    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum = sum < 0 ? nums[i] : (sum + nums[i]);
            max = Math.max(max, sum);
        }
        
        return max;
    }
}