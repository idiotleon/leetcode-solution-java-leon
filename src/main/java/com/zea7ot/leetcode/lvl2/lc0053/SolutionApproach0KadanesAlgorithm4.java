/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  Kadane's Algorithm
 *  https://hackernoon.com/kadanes-algorithm-explained-50316f4fd8a6
 */
package com.zea7ot.leetcode.lvl2.lc0053;

public class SolutionApproach0KadanesAlgorithm4 {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum < 0 ? nums[i] : (sum + nums[i]);
            max = Math.max(max, sum);
        }

        return max;
    }
}