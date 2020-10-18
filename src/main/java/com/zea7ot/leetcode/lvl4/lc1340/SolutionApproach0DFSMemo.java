/**
 * https://leetcode.com/problems/jump-game-v/
 * 
 * Time Complexity:     O(`k` * `N`)
 * Space Complexity:    O(`N`)
 * 
 * References:
 *  https://leetcode.com/problems/jump-game-v/discuss/496520/Top-Down-DP-O(nd)/442759
 *  https://leetcode.com/problems/jump-game-v/discuss/496520/Top-Down-DP-O(nd)
 */
package com.zea7ot.leetcode.lvl4.lc1340;

public class SolutionApproach0DFSMemo {
    public int maxJumps(int[] nums, int d) {
        final int N = nums.length;

        Integer[] memo = new Integer[N];

        int most = 1;
        for (int i = 0; i < N; ++i) {
            most = Math.max(most, dfs(i, nums, d, memo));
        }

        return most;
    }

    private int dfs(int cur, int[] nums, final int D, Integer[] memo) {
        final int N = nums.length;
        if (memo[cur] != null)
            return memo[cur];

        int most = 1;
        for (int hiNext = cur + 1; hiNext <= Math.min(cur + D, N - 1); ++hiNext) {
            if (nums[hiNext] >= nums[cur])
                break;
            most = Math.max(most, 1 + dfs(hiNext, nums, D, memo));
        }

        for (int loNext = cur - 1; loNext >= Math.max(cur - D, 0); --loNext) {
            if (nums[loNext] >= nums[cur])
                break;
            most = Math.max(most, 1 + dfs(loNext, nums, D, memo));
        }

        return memo[cur] = most;
    }
}
