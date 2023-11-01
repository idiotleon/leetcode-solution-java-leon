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
public class SolutionApproach0TopologicalSort2 {
    public List<Integer> findMinHeightTrees(final int n, final int[][] edges) {
        final List<Integer> ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }

        if (n == 1) {
            return Arrays.asList(0);
        }

        final List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new HashSet<>());
        }
        for (final int[] edge : edges) {
            final int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        final Deque<Integer> leaves = new ArrayDeque<>();
        final int[] counts = new int[n];
        for (int i = 0; i < n; ++i) {
            counts[i] = graph.get(i).size();
            if (counts[i] == 1) {
                leaves.add(i);
            }
        }

        int count = n;
        while (count > 2) {
            final int size = leaves.size();
            count -= size;
            for (int i = 0; i < size; ++i) {
                final int leaf = leaves.removeFirst();
                for (final int next : graph.get(leaf)) {
                    if (--counts[next] == 1) {
                        leaves.add(next);
                    }
                }
            }
        }

        ans.addAll(leaves);
        return ans;
    }
}