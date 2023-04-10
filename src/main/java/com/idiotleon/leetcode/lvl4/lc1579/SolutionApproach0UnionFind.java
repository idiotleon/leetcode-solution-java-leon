package com.idiotleon.leetcode.lvl4.lc1579;

import java.util.Arrays;

public class SolutionApproach0UnionFind {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        final int N = edges.length;
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));

        int removal = 0;

        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);

        for (int[] edge : edges) {
            int type = edge[0];
            int a = edge[1];
            int b = edge[2];

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

    private class UnionFind {
        private final int[] ROOTS;
        private final int[] RANKS;
        private int distinct;

        private UnionFind(final int N) {
            this.ROOTS = new int[N + 1];
            for (int i = 0; i <= N; ++i)
                ROOTS[i] = i;

            this.RANKS = new int[N + 1];
            Arrays.fill(RANKS, 1);

            distinct = N;
        }

        private boolean union(int x, int y) {
            final int ROOT_X = find(x), ROOT_Y = find(y);
            if (ROOT_X == ROOT_Y)
                return false;

            if (RANKS[ROOT_X] > RANKS[ROOT_Y]) {
                ROOTS[ROOT_Y] = ROOT_X;
                RANKS[ROOT_X] += RANKS[ROOT_Y];
            } else {
                ROOTS[ROOT_X] = ROOT_Y;
                RANKS[ROOT_Y] += RANKS[ROOT_X];
            }

            --distinct;
            return true;
        }

        private int find(int x) {
            if (x != ROOTS[x])
                ROOTS[x] = find(ROOTS[x]);

            return ROOTS[x];
        }

        private boolean isUnited() {
            return distinct == 1;
        }
    }
}
