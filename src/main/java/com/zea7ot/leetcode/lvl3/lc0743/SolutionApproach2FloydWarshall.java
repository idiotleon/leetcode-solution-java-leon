/**
 * https://leetcode.com/problems/network-delay-time/
 * 
 * Time Complexity:     O(N ^ 3)
 * Space Complexity:    O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/network-delay-time/discuss/183873/Java-solutions-using-Dijkstra-FloydWarshall-and-Bellman-Ford-algorithm
 */
package com.zea7ot.leetcode.lvl3.lc0743;

import java.util.Arrays;

public class SolutionApproach2FloydWarshall {
    public int networkDelayTime(int[][] times, int N, int K) {
        // sanity check
        if (N <= 0 || times == null || times.length == 0)
            return -1;

        final int RANGE = 100 + 1;

        int[][] distances = new int[N][N];
        for (int[] row : distances)
            Arrays.fill(row, RANGE);

        for (int i = 0; i < N; ++i)
            distances[i][i] = 0;

        for (int[] t : times) {
            int u = t[0] - 1, v = t[1] - 1;
            int time = t[2];
            distances[u][v] = time;
        }

        for (int k = 0; k < N; ++k)
            for (int i = 0; i < N; ++i)
                for (int j = 0; j < N; ++j)
                    if (distances[i][j] > distances[i][k] + distances[k][j])
                        distances[i][j] = distances[i][k] + distances[k][j];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; ++i) {
            if (distances[K - 1][i] == RANGE)
                return -1;

            max = Math.max(max, distances[K - 1][i]);
        }

        return max;
    }
}