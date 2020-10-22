/**
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 * 
 * Time Complexity:     O(V ^ 2) ~ O(N ^ 2)
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/min-cost-to-connect-all-points/discuss/843972/Java-Minimum-Spanning-Tree%3A-Prim-%2B-Kruskal
 */
package com.zea7ot.leetcode.lvl4.lc1584;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0PrimsMST {
    public int minCostConnectPoints(int[][] points) {
        final int N = points.length;
        int cost = 0;

        Set<Integer> mst = new HashSet<>();
        mst.add(0);

        int[] distances = new int[N];
        for (int i = 1; i < N; ++i) {
            distances[i] = getDistance(0, i, points);
        }

        while (mst.size() != N) {
            // to find the node with the shortest distance
            int next = -1;
            for (int i = 0; i < N; ++i) {
                if (mst.contains(i))
                    continue;
                if (next == -1 || distances[next] > distances[i])
                    next = i;
            }

            // to pu the node into the Minimum Spanning Tree
            mst.add(next);
            cost += distances[next];

            // to update the `distances` array
            for (int i = 0; i < N; ++i) {
                if (!mst.contains(i)) {
                    distances[i] = Math.min(distances[i], getDistance(i, next, points));
                }
            }
        }

        return cost;
    }

    private int getDistance(int idx1, int idx2, int[][] points) {
        return Math.abs(points[idx1][0] - points[idx2][0]) + Math.abs(points[idx1][1] - points[idx2][1]);
    }
}
