/**
 * https://leetcode.com/problems/friend-circles/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.zea7ot.leetcode.lvl3.lc0547;

import java.util.Arrays;

public class SolutionApproach0UnionFind1 {
    public int findCircleNum(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        final int N = matrix.length;

        UnionFind uf = new UnionFind(matrix);
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < N; ++col) {
                if (matrix[row][col] == 1 && row != col)
                    uf.union(row, col);
            }
        }

        return uf.getCount();
    }

    private class UnionFind {
        private int[] roots;
        private int[] ranks;
        private int count;

        protected UnionFind(int[][] matrix) {
            final int N = matrix.length;

            this.roots = new int[N];
            for (int i = 0; i < N; ++i)
                roots[i] = i;

            this.ranks = new int[N];
            Arrays.fill(ranks, 1);

            this.count = N;
        }

        protected void union(int x, int y) {
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

            --count;
        }

        protected int find(int x) {
            if (x != roots[x])
                return roots[x] = find(roots[x]);

            return roots[x];
        }

        protected int getCount() {
            return count;
        }
    }
}