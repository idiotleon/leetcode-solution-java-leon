/**
 * https://leetcode.com/problems/connecting-cities-with-minimum-cost/
 * 
 * Time Complexity:     O(`N_CONN` * lg(`N_CONN`)) + O(E * lg(V)) ~ O(`N_CONN` * lg(`N_CONN`)) + O(`totaN_CONNlConn` * lg(`N`))
 * Space Complexity:    O(`N`)
 * 
 * References:
 *  https://leetcode.com/problems/connecting-cities-with-minimum-cost/discuss/344867/Java-Kruskal's-Minimum-Spanning-Tree-Algorithm-with-Union-Find
 */
package com.an7one.leetcode.lvl4.lc1135;

import java.util.Arrays;

public class SolutionApproach0KruskalsMST1 {
    public int minimumCost(int N, int[][] connections) {

        // not used
        // final int N_CONN = connections.length;

        Arrays.sort(connections, (a, b) -> Integer.compare(a[2], b[2]));

        UnionFind uf = new UnionFind(N);

        int cost = 0;

        for (int[] conn : connections) {
            int x = conn[0], y = conn[1];
            int rootX = uf.find(x), rootY = uf.find(y);

            if (rootX != rootY) {
                cost += conn[2];
                uf.union(x, y);
            }
        }

        return uf.isolated == 1 ? cost : -1;
    }

    private class UnionFind {
        private final int[] ROOTS;
        private final int[] RANKS;
        private int isolated;

        private UnionFind(final int SIZE) {
            // 1-indexed
            this.ROOTS = new int[SIZE + 1];
            // 1-indexed
            this.RANKS = new int[SIZE + 1];
            for (int i = 0; i <= SIZE; ++i) {
                ROOTS[i] = i;
                RANKS[i] = 1;
            }
            this.isolated = SIZE;
        }

        private int find(int x) {
            if (x != ROOTS[x]) {
                ROOTS[x] = find(ROOTS[x]);
            }

            return ROOTS[x];
        }

        private void union(int x, int y) {
            int rootX = find(x), rootY = find(y);

            if (RANKS[rootX] > RANKS[rootY]) {
                ROOTS[rootY] = rootX;
                ++RANKS[rootX];
            } else {
                ROOTS[rootX] = rootY;
                ++RANKS[rootY];
            }

            --isolated;
        }
    }
}
