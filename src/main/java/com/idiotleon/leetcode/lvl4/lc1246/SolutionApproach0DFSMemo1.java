/**
 * https://leetcode.com/problems/palindrome-removal/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/palindrome-removal/discuss/418835/JavaC++Python3-DP-with-Details-Comments/377453
 *  https://leetcode.com/problems/palindrome-removal/discuss/418835/JavaC%2B%2BPython3-DP-with-Details-Comments
 *  https://youtu.be/FLbqgyJ-70I?t=7635
 */
package com.idiotleon.leetcode.lvl4.lc1246;

public class SolutionApproach0DFSMemo1 {
    public int minimumMoves(int[] nums) {
        final int N = nums.length;
        int[][] memo = new int[N + 1][N + 1];
        return dfs(0, N - 1, nums, memo);
    }

    private int dfs(int i, int j, int[] nums, int[][] memo) {
        if (i > j)
            return 0;
        if (i == j)
            return 1;
        if (memo[i][j] > 0)
            return memo[i][j];
        int best = dfs(i + 1, j, nums, memo) + 1;
        if (nums[i] == nums[i + 1])
            best = Math.min(best, dfs(i + 2, j, nums, memo) + 1);

        for (int k = i + 2; k <= j; ++k) {
            if (nums[i] == nums[k])
                best = Math.min(best, dfs(i + 1, k - 1, nums, memo) + dfs(k + 1, j, nums, memo));
        }

        return memo[i][j] = best;
    }
}