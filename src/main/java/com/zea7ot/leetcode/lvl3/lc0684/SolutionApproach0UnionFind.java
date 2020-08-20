/**
 * https://leetcode.com/problems/redundant-connection
 * 
 * Time Complexity:     O(N), O(lg(N)) with union by rank and path compression
 * Time Complexity:     O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0684;

public class SolutionApproach0UnionFind {
    public int[] findRedundantConnection(int[][] edges) {
        final int RANGE = 2001;
        int[] roots = new int[RANGE];
        for (int i = 0; i < RANGE; ++i)
            roots[i] = i;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            int root1 = find(u, roots), root2 = find(v, roots);
            if (root1 == root2)
                return edge;
            else
                roots[root2] = root1;
        }

        return new int[2];
    }

    private int find(int x, int[] roots) {
        if (x != roots[x]) {
            // path compression
            roots[x] = find(roots[x], roots);
        }
        return roots[x];
    }
}