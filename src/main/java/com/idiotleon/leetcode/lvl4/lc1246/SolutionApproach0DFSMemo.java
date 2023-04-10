/**
 * https://leetcode.com/problems/palindrome-removal/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/palindrome-removal/discuss/418835/JavaC%2B%2BPython3-DP-with-Details-Comments
 *  https://youtu.be/FLbqgyJ-70I?t=7635
 */
package com.idiotleon.leetcode.lvl4.lc1246;

public class SolutionApproach0DFSMemo {
    public int minimumMoves(int[] nums) {
        final int N = nums.length;
        int[][] memo = new int[N][N];
        return dfs(0, N - 1, nums, memo);
    }

    private int dfs(int i, int j, int[] nums, int[][] memo) {
        if (i > j)
            return 0;
        if (memo[i][j] > 0)
            return memo[i][j];
        int best = dfs(i, j - 1, nums, memo) + 1;
        if (j > 0 && nums[j] == nums[j - 1])
            best = Math.min(best, dfs(i, j - 2, nums, memo) + 1);

        for (int k = i; k < j - 1; ++k) {
            if (nums[k] == nums[j])
                best = Math.min(best, dfs(i, k - 1, nums, memo) + dfs(k + 1, j - 1, nums, memo));
        }

        return memo[i][j] = best;
    }
}