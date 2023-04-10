package com.idiotleon.leetcode.lvl2.lc0053.followups.followup0;

import com.idiotleon.util.Constant;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * <p>
 * follow up:
 * to return the start index of the maximum subarray
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * <p>
 * References:
 * https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0KadanesAlgorithm {
    // to return the start index of the maximum subarray
    public int startingIndexOfMaxSubArray(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int localMax = nums[0], globalMax = nums[0];
        int startMaxSubarray = 0, curStart = 0;

        for (int i = 0; i < N; i++) {
            localMax += nums[i];

            if (globalMax < localMax) {
                globalMax = localMax;
                startMaxSubarray = curStart;
            }

            if (localMax < 0) {
                localMax = 0;
                curStart = i + 1;
            }
        }

        return startMaxSubarray;
    }
}