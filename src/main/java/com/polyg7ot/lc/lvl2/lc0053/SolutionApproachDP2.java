/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * Kadane's Algorithm
 * https://hackernoon.com/kadanes-algorithm-explained-50316f4fd8a6
 */
package com.polyg7ot.lc.lvl2.lc0053;

public class SolutionApproachDP2{
    /**
     * to reset if left sum is a negative value
     * https://leetcode.com/problems/maximum-subarray/discuss/20211/Accepted-O(n)-solution-in-java/20527
     */
    public int maxSubArray(int[] nums) {
        int maxSub = Integer.MIN_VALUE, leftPositive = 0;
        for(int i = 0; i < nums.length; i++){
            maxSub = Math.max(maxSub, leftPositive + nums[i]);
            leftPositive = Math.max(0, leftPositive + nums[i]);
        }
        
        return maxSub;
    }
}