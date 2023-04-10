/**
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 * 
 * Time Complexity:     O(E * lg(E))
 * Space Complexity:    O(V)
 * 
 * References:
 *  https://leetcode.com/problems/min-cost-to-connect-all-points/discuss/843972/Java-Minimum-Spanning-Tree%3A-Prim-%2B-Kruskal
 */
package com.idiotleon.leetcode.lvl4.lc1584;

import java.util.PriorityQueue;

public class SolutionApproach0KruskalsMST {
    public int minCostConnectPoints(int[][] points) {
        final int N = points.length;

        PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));
        for (int lo = 0; lo < N; ++lo) {
            for (int hi = lo + 1; hi < N; ++hi) {
                minHeap.add(new Edge(lo, hi, getDistance(lo, hi, points)));
            }
        }

        int cost = 0;

        UnionFind uf = new UnionFind(N);
        while (uf.getIslands() > 1) {
            Edge top = minHeap.poll();

            if (uf.find(top.vertex1) != uf.find(top.vertex2)) {
                cost += top.distance;
                uf.union(top.vertex1, top.vertex2);
            }
        }

        return cost;
    }

    private class UnionFind {
        private int[] roots;
        private int[] ranks;
        private int isolated;

        private UnionFind(final int N) {
            this.isolated = N;

            this.roots = new int[N];
            this.ranks = new int[N];
            for (int i = 0; i < N; ++i) {
                roots[i] = i;
                ranks[i] = 1;
            }

        }

        private int find(int x) {
            if (x != roots[x]) {
                roots[x] = find(roots[x]);
            }

            return roots[x];
        }

        private void union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY)
                return;
            if (ranks[rootX] > ranks[rootY]) {
                roots[rootY] = rootX;
                ++ranks[rootX];
            } else {
                roots[rootX] = rootY;
                ++ranks[rootY];
            }

            --isolated;
        }

        private int getIslands() {
            return isolated;
        }
    }

    private class Edge {
        private int vertex1;
        private int vertex2;
        private int distance;

        private Edge(int vertex1, int vertex2, int distance) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.distance = distance;
        }
    }

    private int getDistance(int idx1, int idx2, int[][] points) {
        return Math.abs(points[idx1][0] - points[idx2][0]) + Math.abs(points[idx1][1] - points[idx2][1]);
    }
}
