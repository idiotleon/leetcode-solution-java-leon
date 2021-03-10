/**
 * https://leetcode.com/problems/knight-dialer/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/knight-dialer/discuss/189322/Java-DFS-with-Memo
 */
package com.an7one.leetcode.lvl3.lc0935;

import java.util.Arrays;

public class SolutionApproach0DFSMemo {
    private static final int[][] DIRS = { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 }, {}, { 0, 1, 7 },
            { 2, 6 }, { 1, 3 }, { 2, 4 } };
    private static final int MOD = (int) 1e9 + 7;

    public int knightDialer(int N) {
        int[][] memo = new int[N + 1][10];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        int ans = 0;
        for (int i = 0; i < 10; ++i) {
            ans += dfs(i, N, memo);
            ans %= MOD;
        }

        return ans;
    }

    private int dfs(int start, final int N, int[][] memo) {
        if (N == 1)
            return 1;

        if (memo[N][start] > -1)
            return memo[N][start];

        memo[N][start] = 0;
        for (int next : DIRS[start]) {
            memo[N][start] += dfs(next, N - 1, memo);
            memo[N][start] %= MOD;
        }

        return memo[N][start];
    }
}