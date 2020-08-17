/**
 * https://leetcode.com/problems/super-egg-drop/
 * 
 * Time Complexity:     O(K * (N ^ 2))
 * Space Complexity:    O(K * N)
 * 
 * TLEed
 * 
 * `dp[k][n]`, minimum number of moves to test `n` floors with `k` eggs
 * 
 * to drop an egg from the `n`-th floor, there are only two outcomes:
 *  1. broken:   `k - 1` egges left, and `n - 1`, 1 ~ `n - 1`, floors left => `dp[k - 1][n - 1]`
 *  2. unbroken: `k` egges left, and 'N - n', `n + 1` ~ `N`, floors left -> `dp[k, N - i]` 
 * 
 * the worse(worst) case is of the interest: max(dp[k - 1][n], dp[k][N - i]).
 * 
 * Among all the choices, to pick the best one
 *  dp[k][n] := 1 + min{max(dp[k - 1][n], dp[k][N - i])}, for 1 <= `n` <= `N`
 * 
 * 
 * References:
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-887-super-egg-drop/
 *  https://www.youtube.com/watch?v=aPY6sps_Q44
 */
package com.zea7ot.leetcode.lvl4.lc0887;

import java.util.Arrays;

public class SolutionApproach1DFSMemo {
    public int superEggDrop(int K, int N) {
        int[][] memo = new int[K + 1][N + 1];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        return dfs(K, N, memo);
    }

    private int dfs(int k, int n, int[][] memo) {
        if (k <= 0)
            return 0;
        if (k == 1)
            return n;
        if (n <= 1)
            return n;

        if (memo[k][n] != Integer.MIN_VALUE)
            return memo[k][n];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; ++i) {
            min = Math.min(min, 1 + Math.max(dfs(k - 1, i - 1, memo), dfs(k, n - i, memo)));
        }

        return memo[k][n] = min;
    }
}