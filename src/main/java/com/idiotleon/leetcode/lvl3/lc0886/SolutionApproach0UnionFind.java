/**
 * https://leetcode.com/problems/possible-bipartition/
 * 
 * Time Complexity:
 * Space Complexity:
 * 
 * References:
 *  https://leetcode.com/problems/possible-bipartition/discuss/195303/Java-Union-Find
 */
package com.idiotleon.leetcode.lvl3.lc0886;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0UnionFind {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        // sanity check
        if (N <= 0)
            return false;

        int[] roots = new int[N + 1];
        for (int i = 0; i <= N; ++i)
            roots[i] = i;

        List<List<Integer>> graph = buildGraph(N, dislikes);
        for (int i = 1; i <= N; ++i) {
            List<Integer> oppos = graph.get(i);
            if (oppos.isEmpty())
                continue;
            int root1 = find(i, roots);
            int root2 = find(oppos.get(0), roots);
            if (root1 == root2)
                return false;
            for (int j = 1; j < oppos.size(); ++j) {
                int root3 = find(oppos.get(j), roots);
                if (root1 == root3)
                    return false;
                roots[root3] = root2;
            }
        }

        return true;
    }

    private int find(int i, int[] roots) {
        while (i != roots[i])
            i = roots[roots[i]];
        return i;
    }

    private List<List<Integer>> buildGraph(final int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; ++i)
            graph.add(new ArrayList<>());

        for (int[] dislike : dislikes) {
            int u = dislike[0], v = dislike[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}