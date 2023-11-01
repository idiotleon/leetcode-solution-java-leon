package com.idiotleon.leetcode.lvl2.lc0310;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/minimum-height-trees/">LC0310</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * <p>
 * <p>
 * to peel off the onion
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/minimum-height-trees/discuss/76055/Share-some-thoughts">LCDiscussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0TopologicalSort1 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if (n <= 0) {
            return leaves;
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

        for (int i = 0; i < n; ++i) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            final List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                final int next = graph.get(leaf).iterator().next();
                graph.get(next).remove(leaf);
                if (graph.get(next).size() == 1) {
                    newLeaves.add(next);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}