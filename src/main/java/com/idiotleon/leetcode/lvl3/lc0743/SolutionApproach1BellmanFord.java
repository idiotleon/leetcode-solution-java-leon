/**
 * https://leetcode.com/problems/network-delay-time/
 * 
 * Time Complexity:     O(V * E) ~ O(N * `times.length`)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/network-delay-time/discuss/109982/C++-Bellman-Ford/198978
 *  https://leetcode.com/problems/network-delay-time/discuss/183873/Java-solutions-using-Dijkstra-FloydWarshall-and-Bellman-Ford-algorithm
 */
package com.idiotleon.leetcode.lvl3.lc0743;

import java.util.Arrays;

public class SolutionApproach1BellmanFord {
    public int networkDelayTime(int[][] times, int N, int K) {
        // sanity check
        if (N <= 0 || times == null || times.length == 0)
            return -1;

        // `dp[i]` represents the minimum distance from `K` to `i`.
        // to interatively update `dp[i]` when shorter distances have been found
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[K] = 0;

        for (int i = 0; i < N; ++i) {
            for (int[] edge : times) {
                int u = edge[0], v = edge[1], w = edge[2];

                if (dp[u] != Integer.MAX_VALUE && dp[v] > dp[u] + w)
                    dp[v] = dp[u] + w;
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; ++i)
            ans = Math.max(ans, dp[i]);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}