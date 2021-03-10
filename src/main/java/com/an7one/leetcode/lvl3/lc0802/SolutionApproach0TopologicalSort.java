/**
 * https://leetcode.com/problems/find-eventual-safe-states/
 * 
 * Time Complexity:     O(V + E) ~ O(N + TOTAL_ELEMENTS)
 * Space Complexity:    O(V + E) ~ O(N + TOTAL_ELEMENTS)
 */
package com.an7one.leetcode.lvl3.lc0802;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class SolutionApproach0TopologicalSort {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (graph == null || graph.length == 0)
            return ans;

        final int N = graph.length;
        int[] counts = new int[N];
        List<List<Integer>> adj = buildGraph(graph, counts);

        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < N; i++)
            if (counts[i] == 0)
                queue.add(i);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans.add(cur);

            for (int parent : adj.get(cur))
                if (--counts[parent] == 0)
                    queue.add(parent);
        }

        Collections.sort(ans);

        return ans;
    }

    private List<List<Integer>> buildGraph(int[][] graph, int[] counts) {
        final int N = graph.length;
        List<List<Integer>> adj = new ArrayList<>(N);
        for (int i = 0; i < N; ++i)
            adj.add(new ArrayList<>());

        for (int parent = 0; parent < N; ++parent) {
            final int LEN = graph[parent].length;
            for (int child : graph[parent]) {
                adj.get(child).add(parent);
            }

            counts[parent] = LEN;
        }

        return adj;
    }
}