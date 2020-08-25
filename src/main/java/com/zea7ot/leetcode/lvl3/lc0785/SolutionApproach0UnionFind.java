/**
 * https://leetcode.com/problems/is-graph-bipartite/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.zea7ot.leetcode.lvl3.lc0785;

public class SolutionApproach0UnionFind {
    public boolean isBipartite(int[][] graph) {
        // sanity check
        if (graph == null || graph.length == 0)
            return false;

        final int N = graph.length;
        UnionFind uf = new UnionFind(N);

        for (int cur = 0; cur < N; cur++) {
            int[] adjacencies = graph[cur];
            for (int j = 0; j < adjacencies.length; j++) {
                if (uf.find(cur) == uf.find(adjacencies[j]))
                    return false;
                uf.union(adjacencies[0], adjacencies[j]);
            }
        }

        return true;
    }

    private class UnionFind {
        private int[] roots;

        protected UnionFind(final int N) {
            roots = new int[N];
            for (int i = 0; i < N; i++)
                roots[i] = i;
        }

        protected void union(int i, int j) {
            int rooti = find(i), rootj = find(j);
            if (rooti != rootj)
                roots[rooti] = rootj;
        }

        protected int find(int i) {
            if (roots[i] != i) {
                return find(roots[i]);
            }

            return roots[i];
        }
    }
}