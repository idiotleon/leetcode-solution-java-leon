/**
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 * 
 * Time Complexity:     O((N ^ 2) * lg(N))
 * Space Complexity:    O(N)
 * 
 * Really like the use of indexes, in stones(int[][]), identifying actual stones/elements
 * 
 * References:
 *  https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/discuss/197693/Java-Union-Find/299524
 */
package com.idiotleon.leetcode.lvl4.lc0947;

public class SolutionApproach0UnionFind {
    public int removeStones(int[][] stones) {
        // sanity check
        if (stones == null || stones.length == 0)
            return 0;

        final int N = stones.length;
        UnionFind uf = new UnionFind(N);

        for (int i = 0; i < N - 1; ++i) {
            for (int j = i + 1; j < N; ++j) {
                int[] stone1 = stones[i], stone2 = stones[j];

                if (stone1[0] == stone2[0] || stone1[1] == stone2[1]) {
                    uf.union(i, j);
                }
            }
        }

        return N - uf.getCount();
    }

    private class UnionFind {
        private int[] roots;
        private int[] ranks;
        private int N;

        private UnionFind(final int N) {
            this.N = N;

            this.roots = new int[N];
            this.ranks = new int[N];
            for (int i = 0; i < N; ++i) {
                roots[i] = i;
                ranks[i] = 1;
            }
        }

        private void union(int x, int y) {
            int rootX = find(x), rootY = find(y);

            if (ranks[rootX] > ranks[rootY]) {
                roots[rootY] = rootX;
                ++ranks[rootX];
            } else {
                roots[rootX] = rootY;
                ++ranks[rootY];
            }
        }

        private int find(int x) {
            if (x != roots[x]) {
                roots[x] = find(roots[x]);
            }

            return roots[x];
        }

        private int getCount() {
            int count = 0;
            for (int i = 0; i < N; ++i) {
                if (roots[i] == i)
                    ++count;
            }
            return count;
        }
    }
}