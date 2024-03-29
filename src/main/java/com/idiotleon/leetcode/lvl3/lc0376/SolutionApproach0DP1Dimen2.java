package com.idiotleon.leetcode.lvl3.lc0376;

import com.idiotleon.util.Constant;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/wiggle-subsequence/">LC0376</a>
 * <p>
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/wiggle-subsequence/discuss/84883/Two-solutions.-One-is-DP-the-other-is-greedy-(8-lines)">Leetcode</a>.
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP1Dimen2 {
    public int wiggleMaxLength(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[] up = new int[N];
        Arrays.fill(up, 1);
        int[] down = new int[N];
        Arrays.fill(down, 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                } else if (nums[j] > nums[i]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }
        }

        return Math.max(up[N - 1], down[N - 1]);
    }
}