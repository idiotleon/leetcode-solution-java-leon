/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * 
 * Kadane's Algorithm
 * https://hackernoon.com/kadanes-algorithm-explained-50316f4fd8a6
 * https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d
 */
package com.zea7ot.lc.lvl2.lc0053;

public class SolutionApproachDP{
    public int maxSubArray4(int[] nums) {
        int localMax = 0, globalMax = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            localMax = Math.max(nums[i], localMax + nums[i]);
            if(localMax > globalMax){
                globalMax = localMax;
            }
        }
        
        return globalMax;
    }
}