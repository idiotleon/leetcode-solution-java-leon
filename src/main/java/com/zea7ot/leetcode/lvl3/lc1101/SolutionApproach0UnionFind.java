/**
 * @author: Leon
 * https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N)
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl3.lc1101;

import java.util.Arrays;

public class SolutionApproach0UnionFind {
    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));

        UnionFind uf = new UnionFind(N);

        for (int[] log : logs) {
            int earliest = log[0];
            int idA = log[1], idB = log[2];
            uf.union(idA, idB);

            if (uf.getIsolated() == 1)
                return earliest;
        }

        return -1;
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

        private int getIsolated() {
            return isolated;
        }
    }
}
