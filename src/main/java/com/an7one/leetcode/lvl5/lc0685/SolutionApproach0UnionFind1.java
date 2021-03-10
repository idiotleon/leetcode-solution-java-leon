/**
 * https://leetcode.com/problems/redundant-connection-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/redundant-connection-ii/discuss/108058/one-pass-disjoint-set-solution-with-explain
 *  https://leetcode.com/problems/redundant-connection-ii/discuss/278105/topic
 *  https://leetcode.com/problems/redundant-connection-ii/discuss/108045/C%2B%2BJava-Union-Find-with-explanation-O(n)
 * 
 * Similar Problems:
 *  https://leetcode.com/problems/redundant-connection/
 */
package com.an7one.leetcode.lvl5.lc0685;

public class SolutionApproach0UnionFind1 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        final int N = edges.length;
        int edgeWithTwoParents = -1, edgeToCycle = -1;

        // immediate parents
        int[] parents = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int u = edges[i][0], v = edges[i][1];

            if (parents[v] != 0) {
                edgeWithTwoParents = i;
                break;
            } else {
                parents[v] = u;
            }
        }

        UnionFind unionFind = new UnionFind(N + 1);
        for (int i = 0; i < N; i++) {
            if (i == edgeWithTwoParents)
                continue;
            int u = edges[i][0], v = edges[i][1];
            if (!unionFind.union(u, v)) {
                edgeToCycle = i;
                break;
            }
        }

        // to handle the case where only the cyclic problem exists
        if (edgeWithTwoParents == -1)
            return edges[edgeToCycle];

        // to handle the case where the wrong edge has been remove,
        // by which a cycle exists, and the graph is separated into two parts
        if (edgeToCycle != -1) {
            int v = edges[edgeWithTwoParents][1];
            int u = parents[v];
            return new int[] { u, v };
        }

        return edges[edgeWithTwoParents];

        /*
         * another set of conditions which is easier to understand, but verbose
         * 
         * if(edgeToCycle != -1 && edgeWithTwoParents != -1){ int v =
         * edges[edgeWithTwoParents][1], u = parents[v]; return new int[]{u, v}; }
         * 
         * if(edgeToCycle != -1) return edges[edgeToCycle]; if(edgeWithTwoParents != -1)
         * return edges[edgeWithTwoParents];
         */
    }

    private class UnionFind {
        // ultimate roots
        private int[] roots;
        private int[] ranks;

        protected UnionFind(final int N) {
            this.roots = new int[N];
            for (int i = 0; i < N; i++) {
                roots[i] = i;
            }
            this.ranks = new int[N];
        }

        protected int find(int x) {
            if (x != roots[x]) {
                roots[x] = find(roots[x]);
            }

            return roots[x];
        }

        protected boolean union(int x, int y) {
            int rootX = find(x), rootY = find(y);

            if (rootX == rootY)
                return false;

            if (ranks[rootX] > ranks[rootY])
                roots[rootY] = rootX;
            else if (ranks[rootX] < ranks[rootY])
                roots[rootX] = rootY;
            else {
                roots[rootY] = rootX;
                ++ranks[rootX];
            }

            return true;
        }
    }
}