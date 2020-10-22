/**
 * @author: Leon
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(26) ~ O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0990;

public class SolutionApproach0UnionFind {
    private static final int RANGE = 26;

    private static final char EQUAL = '=';
    private static final char NOT_EQUAL = '!';

    public boolean equationsPossible(String[] equations) {
        // not used
        // final int N = equations.length;

        UnionFind uf = new UnionFind(RANGE);

        for (String equation : equations) {
            final char[] CHS = equation.toCharArray();
            if (CHS[1] == EQUAL) {
                uf.union(CHS[0] - 'a', CHS[3] - 'a');
            }
        }

        for (String equation : equations) {
            final char[] CHS = equation.toCharArray();
            if (CHS[1] == NOT_EQUAL) {
                int root1 = uf.find(CHS[0] - 'a');
                int root2 = uf.find(CHS[3] - 'a');

                if (root1 == root2)
                    return false;
            }
        }

        return true;
    }

    private class UnionFind {
        private int[] roots;
        private int[] ranks;

        private UnionFind(final int N) {
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
        }
    }
}
