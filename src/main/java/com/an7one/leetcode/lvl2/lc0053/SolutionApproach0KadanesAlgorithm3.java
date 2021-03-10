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
package com.an7one.leetcode.lvl2.lc0053;

public class SolutionApproach0KadanesAlgorithm3 {
    /**
     * to reset if left sum is a negative value
     * https://leetcode.com/problems/maximum-subarray/discuss/20211/Accepted-O(n)-solution-in-java/20527
     */
    public int maxSubArray(int[] nums) {
        int maxSub = Integer.MIN_VALUE, leftPositive = 0;
        for (int i = 0; i < nums.length; i++) {
            maxSub = Math.max(maxSub, leftPositive + nums[i]);
            leftPositive = Math.max(0, leftPositive + nums[i]);
        }

        return maxSub;
    }
}