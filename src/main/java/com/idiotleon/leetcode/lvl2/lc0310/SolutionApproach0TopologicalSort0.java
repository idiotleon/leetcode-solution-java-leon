package com.idiotleon.leetcode.lvl2.lc0310;

import com.idiotleon.util.Constant;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/minimum-height-trees/">LC0310</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * <p>
 * to peel off the onion
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/minimum-height-trees/discuss/76055/Share-some-thoughts/211634">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0TopologicalSort0 {
    public List<Integer> findMinHeightTrees(final int n, final int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }

        if (n == 1) {
            return List.of(0);
        }

        final int[] counts = new int[n];
        final List<List<Integer>> graph = buildGraph(counts, n, edges);

        final Deque<Integer> leaves = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            counts[i] = graph.get(i).size();
            if (counts[i] == 1) {
                leaves.add(i);
            }
        }

        while (!leaves.isEmpty()) {
            final int size = leaves.size();
            final List<Integer> res = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                final int leaf = leaves.removeFirst();
                res.add(leaf);
                for (final int next : graph.get(leaf)) {
                    if (--counts[next] == 1) {
                        leaves.add(next);
                    }
                }
            }
            ans = res;
        }

        return ans;
    }

    private List<List<Integer>> buildGraph(final int[] counts, final int n, final int[][] edges){
        final List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        for (final int[] edge : edges) {
            final int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}