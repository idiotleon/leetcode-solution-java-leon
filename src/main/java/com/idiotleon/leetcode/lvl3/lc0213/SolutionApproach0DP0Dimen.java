/**
 * https://leetcode.com/problems/house-robber-ii/
 * 
 * Time Complexity:     O(2 * N) ~ O(N)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl3.lc0213;

public class SolutionApproach0DP0Dimen {
    public int rob(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        if (N == 1)
            return nums[0];

        // if the first one is going to be robbed
        int robFirst = rob(0, N - 2, nums);
        // if the second one is going to be robbed
        int robSecond = rob(1, N - 1, nums);

        return Math.max(robFirst, robSecond);
    }

    private int rob(int lo, int hi, int[] nums) {
        int inclusive = 0, exclusive = 0;

        for (int i = lo; i <= hi; ++i) {
            final int PREV_INCLUDE = inclusive;
            final int PREV_EXCLUDE = exclusive;
            // if this one is going to be robbed,
            // the previous one should be included
            inclusive = PREV_EXCLUDE + nums[i];
            // if this one is NOT going to be robbed
            exclusive = Math.max(PREV_EXCLUDE, PREV_INCLUDE);
        }

        return Math.max(inclusive, exclusive);
    }
}