/**
 * https://leetcode.com/problems/friend-circles/
 * 
 * Time Complexity:     O(`NR` * `NC`)
 * Space Complexity:    O(`NR` * `NC`)
 * 
 * References:
 *  https://leetcode.com/problems/friend-circles/discuss/101431/Stupid-question:-How-is-this-question-different-from-Number-of-Islands/332347
 *  https://leetcode.com/problems/friend-circles/discuss/101336/Java-solution-Union-Find
 */
package com.an7one.leetcode.lvl3.lc0547;

public class SolutionApproach0UnionFind {
    public int findCircleNum(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        final int N = matrix.length;

        UnionFind uf = new UnionFind(N);
        for (int lo = 0; lo < N; ++lo) {
            for (int hi = lo + 1; hi < N; ++hi) {
                if (matrix[lo][hi] == 1)
                    uf.union(lo, hi);
            }
        }

        return uf.getCount();
    }

    private class UnionFind {
        private int[] roots;
        private int[] ranks;
        private int count;

        protected UnionFind(final int N) {
            this.roots = new int[N];
            this.ranks = new int[N];
            for (int i = 0; i < N; ++i) {
                roots[i] = i;
                ranks[i] = 1;
            }

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