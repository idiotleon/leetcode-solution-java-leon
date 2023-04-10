/**
 * https://leetcode.com/problems/paint-house/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl3.lc0256;

public class SolutionApproach0DP0Dimen3 {
    public int minCost(int[][] costs) {
        // sanity check
        if (costs == null || costs.length == 0)
            return 0;

        final int N = costs.length;
        for (int i = 1; i < N; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        return Math.min(Math.min(costs[N - 1][0], costs[N - 1][1]), costs[N - 1][2]);
    }
}