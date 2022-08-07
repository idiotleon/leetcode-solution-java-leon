package com.an7one.leetcode.lvl3.lc0300.followup;

import com.an7one.util.Constant;

import java.util.Arrays;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">LC0300</a>
 * <p>
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(1)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/discuss/74825/Short-Java-solution-using-DP-O(n-log-n)">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1DPWithBinarySearch {
    public int lengthOfLIS(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0) return 0;

        final int L = nums.length;
        final int[] dp = new int[L];

        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) i = -(i + 1);
            dp[i] = num;
            if (i == len) ++len;
        }

        return len;
    }
}