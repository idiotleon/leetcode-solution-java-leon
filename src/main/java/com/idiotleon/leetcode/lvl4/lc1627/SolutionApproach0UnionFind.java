/**
 * https://leetcode.com/problems/graph-connectivity-with-threshold/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.idiotleon.leetcode.lvl4.lc1627;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0UnionFind {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        UnionFind uf = new UnionFind(n + 1);

        for (int i = threshold + 1; i <= n; ++i) {
            for (int j = i; j <= n; j += i) {
                uf.union(i, j);
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            ans.add(uf.find(query[0]) == uf.find(query[1]));
        }

        return ans;
    }

    private class UnionFind {
        private final int[] ROOTS;
        private final int[] RANKS;

        private UnionFind(final int N) {
            this.ROOTS = new int[N];
            this.RANKS = new int[N];
            for (int i = 0; i < N; ++i) {
                ROOTS[i] = i;
                RANKS[i] = 1;
            }
        }

        private int find(int x) {
            if (ROOTS[x] != x) {
                x = find(ROOTS[x]);
            }

            return ROOTS[x];
        }

        private void union(int x, int y) {
            final int ROOT_X = find(x);
            final int ROOT_Y = find(y);

            if (RANKS[ROOT_X] > RANKS[ROOT_Y]) {
                ROOTS[ROOT_Y] = ROOT_X;
                ++RANKS[ROOT_X];
            } else {
                ROOTS[ROOT_X] = ROOT_Y;
                ++RANKS[ROOT_Y];
            }
        }
    }
}
