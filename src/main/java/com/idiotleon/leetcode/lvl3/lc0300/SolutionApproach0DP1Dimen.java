package com.idiotleon.leetcode.lvl3.lc0300;

import com.idiotleon.util.Constant;

import java.util.Arrays;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">LC0300</a>
 * <p>
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/discuss/74836/My-easy-to-understand-O(n2)-solution-using-DP-with-video-explanation/144619">LC Discussion</a>
 * <a href="https://youtu.be/7DKFpWnaxLI">Youtube</a>
 * <a href="http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-300-longest-increasing-subsequence/">Huahua</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP1Dimen {
    public int lengthOfLIS(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        // Elements are length(s) of LISs ending with num(nums[i - 1])
        final int[] dp = new int[N];
        // the default LIS of each element in nums(int[]) is 1, NOT 0
        // e.g. were they completely strictly decreasing in the worst case
        Arrays.fill(dp, 1);
        int longest = 1;

        for (int hi = 1; hi < N; ++hi) {
            // either line27 or line31 works
            // dp[i] = 1
            for (int lo = 0; lo < hi; ++lo) {
                if (nums[hi] > nums[lo]) {
                    dp[hi] = Math.max(dp[hi], dp[lo] + 1);
                }
            }

            longest = Math.max(longest, dp[hi]);
        }

        return longest;
    }
}