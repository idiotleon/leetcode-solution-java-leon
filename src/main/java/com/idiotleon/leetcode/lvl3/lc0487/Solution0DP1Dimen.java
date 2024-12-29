package com.idiotleon.leetcode.lvl3.lc0487;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/max-consecutive-ones-ii/">LC0487</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/max-consecutive-ones-ii/discuss/96928/Java-DP-O(n)-Solution">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class Solution0DP1Dimen {
    public int findMaxConsecutiveOnes(int[] nums) {
        final int N = nums.length;
        int ans = 0, count = 0;
        final int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = count;
            if (nums[i] == 1) {
                ++count;
                ans = Math.max(ans, count);
            } else {
                count = 0;
            }
        }

        count = 0;
        for (int i = N - 1; i >= 0; --i) {
            dp[i] += count;
            if (nums[i] == 1) {
                ++count;
            } else {
                count = 0;
            }
        }

        for (int i = 0; i < N; ++i) {
            if (nums[i] == 0) {
                ans = Math.max(ans, dp[i] + 1);
            }
        }

        return ans;
    }
}