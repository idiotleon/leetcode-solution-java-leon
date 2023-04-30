package com.idiotleon.leetcode.lvl4.lc1579;

import com.idiotleon.util.Constant;

import java.util.Arrays;

/**
 * {@code @author:} Leon
 * <url><a href="https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/description/">LC1579</a></url>
 * Time Complexity:
 * Space Complexity:
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0UnionFind {
    /**
     * @param n     the total number of vertices
     * @param edges the edges of the graph
     * @return the largest count of edges to remove
     */
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        final int N = edges.length;
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));

        int removal = 0;

        final UnionFind alice = new UnionFind(n);
        final UnionFind bob = new UnionFind(n);

        for (int[] edge : edges) {
            final int type = edge[0];
            final int a = edge[1];
            final int b = edge[2];

            switch (type) {
                case 1:
                    if (alice.union(a, b))
                        ++removal;
                    break;
                case 2:
                    if (bob.union(a, b))
                        ++removal;
                    break;
                case 3:
                    if (alice.union(a, b) | bob.union(a, b))
                        ++removal;
                    break;
            }
        }

        return (alice.isUnited() && bob.isUnited()) ? N - removal : -1;
    }

    private static class UnionFind {
        private final int[] roots;
        private final int[] ranks;
        private int distinct;

        private UnionFind(final int N) {
            this.roots = new int[N + 1];
            for (int i = 0; i <= N; ++i) {
                roots[i] = i;
            }

            this.ranks = new int[N + 1];
            Arrays.fill(ranks, 1);

            distinct = N;
        }

        private boolean union(int x, int y) {
            final int rootX = find(x), rootY = find(y);
            if (rootX == rootY)
                return false;

            if (ranks[rootX] > ranks[rootY]) {
                roots[rootY] = rootX;
                ranks[rootX] += ranks[rootY];
            } else {
                roots[rootX] = rootY;
                ranks[rootY] += ranks[rootX];
            }

            --distinct;
            return true;
        }

        private int find(int x) {
            if (x != roots[x])
                roots[x] = find(roots[x]);

            return roots[x];
        }

        private boolean isUnited() {
            return distinct == 1;
        }
    }
}
