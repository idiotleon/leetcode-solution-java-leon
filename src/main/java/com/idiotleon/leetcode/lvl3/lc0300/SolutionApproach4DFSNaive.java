package com.idiotleon.leetcode.lvl3.lc0300;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">LC0300</a>
 * <p>
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * O(N), the call stack
 * <p>
 * Reference:
 * <a href="https://www.youtube.com/watch?v=CE2b_-XfVDk">Youtube</a>
 * <a href="https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestIncreasingSubsequence.java">Github</a>
 * <a href="https://www.youtube.com/watch?v=7DKFpWnaxLI&list=PLLuMmzMTgVK7vEbeHBDD42pqqG36jhuOr&index=94">Youtube</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach4DFSNaive {
    public int lengthOfLIS(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = lengthOfLIS(nums, i + 1, nums[i]);
            maxLen = Math.max(maxLen, len);
        }

        return maxLen + 1;
    }

    private int lengthOfLIS(int[] nums, int pos, int lastNum) {
        if (pos == nums.length)
            return 0;

        int t1 = 0;
        if (nums[pos] > lastNum) {
            t1 = 1 + lengthOfLIS(nums, pos + 1, nums[pos]);
        }

        int t2 = lengthOfLIS(nums, pos + 1, lastNum);
        return Math.max(t1, t2);
    }
}