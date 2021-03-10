/**
 * https://leetcode.com/problems/longest-increasing-subsequence
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-300-longest-increasing-subsequence/
 *  https://youtu.be/7DKFpWnaxLI
 */
package com.an7one.leetcode.lvl3.lc0300;

public class SolutionApproach0DFSMemo {
    public int lengthOfLIS(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[] memo = new int[N];
        // this corresponds to line 46
        // Arrays.fill(memo, 1);
        int longest = 0;
        for (int i = 0; i < N; ++i) {
            longest = Math.max(longest, dfs(i, nums, memo));
        }

        return longest;
    }

    /**
     * to return the length of LIS ending with nums[idx]
     */
    private int dfs(int idx, int[] nums, int[] memo) {
        if (idx == 0)
            return 1;
        // this corresponds to line 31
        // if(memo[idx] > 1) return memo[idx];
        if (memo[idx] > 0)
            return memo[idx];

        int longest = 1;
        int hi = idx;
        for (int lo = 0; lo < hi; ++lo) {
            if (nums[idx] > nums[lo]) {
                longest = Math.max(longest, 1 + dfs(lo, nums, memo));
            }
        }

        return memo[idx] = longest;
    }
}