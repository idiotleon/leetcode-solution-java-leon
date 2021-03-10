/**
 * https://leetcode.com/problems/redundant-connection-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/redundant-connection-ii/discuss/278105/topic
 *  https://leetcode.com/problems/redundant-connection-ii/discuss/108058/one-pass-disjoint-set-solution-with-explain
 *  https://leetcode.com/problems/redundant-connection-ii/discuss/108045/C%2B%2BJava-Union-Find-with-explanation-O(n)
 */
package com.an7one.leetcode.lvl5.lc0685;

import java.util.Arrays;

public class SolutionApproach0UnionFind {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        final int N = edges.length;

        // parents are "immediate" parents, while roots are "ultimate" roots.
        int[] parents = new int[N + 1], roots = new int[N + 1];
        Arrays.fill(parents, -1);

        int first = -1, second = -1, last = -1;
        for (int i = 0; i < N; ++i) {
            int u = edges[i][0], v = edges[i][1];
            // when vertex v has a parent,
            // which means the indegree of this node is 2
            if (parents[v] != -1) {
                // to keep account of the first parent
                first = parents[v];
                // to keep account of the second parent
                second = i;
                continue;
            }

            parents[v] = i;

            int rootU = find(u, roots);
            // a cycle has been detected
            if (rootU == v)
                last = i;
            else
                roots[v] = rootU;
        }

        if (last == -1)
            return edges[second]; // no cycle found by removing "second"
        if (second == -1)
            return edges[last]; // no edge removed
        return edges[first];
    }

    private int find(int i, int[] roots) {
        return roots[i] == 0 ? i : (roots[i] = find(roots[i], roots));
    }
}