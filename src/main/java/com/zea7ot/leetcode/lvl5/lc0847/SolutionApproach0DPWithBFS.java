/**
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes/
 * 
 * Time Complexity:     O(N * (2 ^ N))
 * Space Complexity:    O(N * (2 ^ N))
 * 
 * References:
 *  https://leetcode.com/problems/shortest-path-visiting-all-nodes/discuss/135686/Java-DP-Solution
 */
package com.zea7ot.leetcode.lvl5.lc0847;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SolutionApproach0DPWithBFS {
    public int shortestPathLength(int[][] graph) {
        final int N = graph.length;
        final int FULL_MASK = (1 << N) - 1;

        int[][] dp = new int[N][FULL_MASK + 1];

        Deque<State> queue = new ArrayDeque<>();
        for (int i = 0; i < N; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][1 << i] = 0;
            queue.offer(new State(i, 1 << i));
        }

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                State cur = queue.poll();
                int curVertex = cur.vertex;
                int curBitMask = cur.bitMask;

                for (int nextVertex : graph[curVertex]) {
                    int nextBitMask = curBitMask | (1 << nextVertex);

                    if (dp[nextVertex][nextBitMask] > dp[curVertex][curBitMask] + 1) {
                        dp[nextVertex][nextBitMask] = dp[curVertex][curBitMask] + 1;
                        queue.offer(new State(nextVertex, nextBitMask));
                    }
                }
            }
        }

        int shortest = Integer.MAX_VALUE;
        for (int[] row : dp) {
            shortest = Math.min(shortest, row[FULL_MASK]);
        }
        return shortest;
    }

    private class State {
        private int vertex;
        private int bitMask;

        private State(int vertex, int bitMask) {
            this.vertex = vertex;
            this.bitMask = bitMask;
        }
    }
}
