/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  Kadane's Algorithm
 *  https://hackernoon.com/kadanes-algorithm-explained-50316f4fd8a6
 *  https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d
 */
package com.idiotleon.leetcode.lvl2.lc0053;

public class SolutionApproach0KadanesAlgorithm {
    public int maxSubArray(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        int localMax = 0, globalMax = Integer.MIN_VALUE;

        // not used
        // final int N = nums.length;
        for (int num : nums) {
            localMax += num;

            if (globalMax < localMax) {
                globalMax = localMax;
            }

            if (localMax < 0) {
                localMax = 0;
            }
        }

        return globalMax;
    }
}