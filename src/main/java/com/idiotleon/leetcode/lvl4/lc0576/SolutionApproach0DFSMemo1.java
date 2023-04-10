package com.idiotleon.leetcode.lvl4.lc0576;

import com.idiotleon.util.Constant;

/**
 * https://leetcode.com/problems/out-of-boundary-paths/
 * <p>
 * Time Complexity:     O(`m` * `n` * `maxMove`)
 * Space Complexity:    O(`m` * `n`)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSMemo1 {
    private final static int[] DIRS = {0, 1, 0, -1, 0};
    private final static int MOD = 1000000000 + 7;

    public int findPaths(int m, int n, int N, int i, int j) {
        long[][][] memo = new long[m][n][N + 1];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                for (int step = 0; step < N + 1; step++) {
                    memo[row][col][step] = -1;
                }
            }
        }

        return (int) (dfs(m, n, N, i, j, memo) % MOD);
    }

    private long dfs(int m, int n, int N, int row, int col, long[][][] memo) {
        if (row < 0 || row >= m || col < 0 || col >= n)
            return 1;

        if (N == 0)
            return 0;

        if (memo[row][col][N] != -1)
            return memo[row][col][N];

        memo[row][col][N] = 0;
        for (int d = 0; d < 4; d++) {
            int r = row + DIRS[d], c = col + DIRS[d + 1];
            memo[row][col][N] += dfs(m, n, N - 1, r, c, memo) % MOD;
        }
        return memo[row][col][N];
    }
}