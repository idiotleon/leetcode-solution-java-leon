/**
 * https://leetcode.com/problems/minimum-number-of-refueling-ts/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * dp[t], means the furthest distance one can get with `t` times of refueling
 *  if dp[t] >= stations[idx][0], one can refuel:
 *  dp[t + 1] = max(dp[t + 1], dp[t] + stations[idx][1])
 * 
 * References:
 *  https://leetcode.com/problems/minimum-number-of-refueling-ts/discuss/149839/DP-O(N2)-and-Priority-Queue-O(NlogN)
 */
package com.idiotleon.leetcode.lvl4.lc0871;

public class SolutionApproach0DP1Dimen {
    public int minRefuelts(int target, int startFuel, int[][] stations) {
        final int N = stations.length;

        long[] dp = new long[N + 1];
        dp[0] = startFuel;

        for (int idx = 0; idx < N; ++idx) {
            for (int t = idx; t >= 0; --t) {
                if (dp[t] >= stations[idx][0]) {
                    dp[t + 1] = Math.max(dp[t + 1], dp[t] + stations[idx][1]);
                }
            }
        }

        for (int i = 0; i <= N; ++i) {
            if (dp[i] >= target) {
                return i;
            }
        }

        return -1;
    }
}
