/**
 * https://leetcode.com/problems/knight-dialer/
 * 
 * Time Complexity:     O(10 * N) ~ O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/knight-dialer/discuss/189251/C++-5-lines-DP/194503
 */
package com.idiotleon.leetcode.lvl3.lc0935;

import java.util.Arrays;

public class SolutionApproach0DP {
    private static final int[][] DIRS = { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 }, {}, { 0, 1, 7 },
            { 2, 6 }, { 1, 3 }, { 2, 4 } };
    private static final int MOD = (int) 1e9 + 7;

    public int knightDialer(int N) {
        int[] dp = new int[10];
        Arrays.fill(dp, 1);
        while (--N > 0) {
            int[] next = new int[10];
            for (int d = 0; d < 10; ++d) {
                for (int dir : DIRS[d]) {
                    next[d] = (dp[dir] + next[d]) % MOD;
                }
            }

            dp = next;
        }

        int sum = 0;
        for (int num : dp) {
            sum = (sum + num) % MOD;
        }

        return sum;
    }
}