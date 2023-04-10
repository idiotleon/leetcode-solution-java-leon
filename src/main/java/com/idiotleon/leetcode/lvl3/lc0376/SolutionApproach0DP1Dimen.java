package com.idiotleon.leetcode.lvl3.lc0376;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/wiggle-subsequence/">LC0376</a>
 * <p>
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(`N`)
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/wiggle-subsequence/discuss/84843/Easy-understanding-DP-solution-with-O(n)-Java-version">Leetcode</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP1Dimen {
    public int wiggleMaxLength(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[] up = new int[N];
        up[0] = 1;

        int[] down = new int[N];
        down[0] = 1;

        for (int i = 1; i < N; i++) {
            if (nums[i - 1] < nums[i]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i - 1] > nums[i]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }

        return Math.max(down[N - 1], up[N - 1]);
    }
}