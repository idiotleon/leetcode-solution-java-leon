/**
 * https://leetcode.com/problems/minimize-malware-spread/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/minimize-malware-spread/discuss/320624/Java-UnionFind-with-explanation
 */
package com.zea7ot.leetcode.lvl4.lc0924;

import java.util.Arrays;

public class SolutionApproach0UnionFind {
    public int minMalwareSpread(int[][] graph, int[] initials) {
        final int N = graph.length;

        UnionFind uf = new UnionFind(N);
        for (int row = 0; row < N; ++row) {
            for (int col = row + 1; col < N; ++col) {
                if (graph[row][col] == 1) {
                    uf.union(row, col);
                }
            }
        }

        Arrays.sort(initials);
        return uf.getMaxMalwareSize(initials);
    }

    private class UnionFind {
        private int[] roots;
        private int[] sizes;
        private final int N;

        private UnionFind(final int N) {
            this.N = N;
            this.roots = new int[N];
            this.sizes = new int[N];
            for (int i = 0; i < N; ++i) {
                roots[i] = i;
                sizes[i] = 1;
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
            if (sizes[rootX] > sizes[rootY]) {
                roots[rootY] = rootX;
                sizes[rootX] += sizes[rootY];
            } else {
                roots[rootX] = rootY;
                sizes[rootY] += sizes[rootX];
            }
        }

        private int getMaxMalwareSize(int[] initials) {
            int[] malwareCnts = new int[N];
            for (int init : initials) {
                ++malwareCnts[find(init)];
            }

            int maxSize = 0, nodeMostContagious = initials[0];

            for (int init : initials) {
                int root = find(init);
                int malwareCnt = malwareCnts[root];
                if (malwareCnt == 1) {
                    int size = sizes[root];
                    if (size > maxSize) {
                        maxSize = size;
                        nodeMostContagious = init;
                    }
                }
            }

            return nodeMostContagious;
        }
    }
}
