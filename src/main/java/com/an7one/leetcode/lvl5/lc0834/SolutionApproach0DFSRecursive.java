/**
 * https://leetcode.com/problems/sum-of-distances-in-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/sum-of-distances-in-tree/discuss/130583/C%2B%2BJavaPython-Pre-order-and-Post-order-DFS-O(N)
 */
package com.an7one.leetcode.lvl5.lc0834;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0DFSRecursive {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[] distances = new int[N];
        int[] counts = new int[N];

        List<Set<Integer>> graph = buildGraph(edges, N);

        postorder(0, -1, counts, graph, distances);
        preorder(0, -1, counts, graph, N, distances);

        return distances;
    }

    private void postorder(int cur, int prev, int[] counts, List<Set<Integer>> graph, int[] distances) {
        for (int next : graph.get(cur)) {
            if (next == prev)
                continue;
            postorder(next, cur, counts, graph, distances);
            counts[cur] += counts[next];
            distances[cur] += distances[next] + counts[next];
        }

        ++counts[cur];
    }

    private void preorder(int cur, int prev, int[] counts, List<Set<Integer>> graph, final int N, int[] distances) {
        for (int next : graph.get(cur)) {
            if (next == prev)
                continue;

            distances[next] = distances[cur] - counts[next] + N - counts[next];
            preorder(next, cur, counts, graph, N, distances);
        }
    }

    private List<Set<Integer>> buildGraph(int[][] edges, final int N) {
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            graph.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}
