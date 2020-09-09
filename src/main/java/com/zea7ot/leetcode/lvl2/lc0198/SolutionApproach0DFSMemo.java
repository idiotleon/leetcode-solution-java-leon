/**
 * https://leetcode.com/problems/house-robber/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N) + O(N) ~ O(N)
 * 
 * References:
 *  https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 */
package com.zea7ot.leetcode.lvl2.lc0198;

import java.util.Arrays;

public class SolutionApproach0DFSMemo {
    public int rob(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        final int[] MEMO = new int[N + 1];
        Arrays.fill(MEMO, -1);

        return dfs(N - 1, nums, MEMO);
    }

    private int dfs(int idx, int[] nums, final int[] MEMO) {
        if (idx < 0)
            return 0;
        if (MEMO[idx] >= 0)
            return MEMO[idx];

        int res = Math.max(dfs(idx - 1, nums, MEMO), dfs(idx - 2, nums, MEMO) + nums[idx]);
        return MEMO[idx] = res;
    }
}