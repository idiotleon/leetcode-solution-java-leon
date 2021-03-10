/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * follow up: 
 *  to return the length of the maximum subarray
 */
package com.an7one.leetcode.lvl2.lc0053.followups.followup1;

public class SolutionApproach0KadanesAlgorithm {
    // to return the length of the maximum subarray
    public int lengthOfMaxSubArray(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int globalMax = Integer.MIN_VALUE, localMax = 0;
        int startMaxSubarray = 0, curStart = 0, endMaxSubarray = 0;

        for (int i = 0; i < N; i++) {
            localMax += nums[i];

            if (globalMax < localMax) {
                globalMax = localMax;
                // to get the start from the previous round
                startMaxSubarray = curStart;
                // this is the end of the current round
                endMaxSubarray = i;
            }

            if (localMax < 0) {
                localMax = 0;
                // this is the start of the next round
                curStart = i + 1;
            }
        }

        return (endMaxSubarray - startMaxSubarray + 1);
    }
}