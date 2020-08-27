/**
 * https://leetcode.com/problems/sequence-reconstruction/
 * 
 * Time Complexity:     O(N + TOTAL_SIZE(`seqs`))
 * Space Complexity:    O(N + TOTAL_SIZE(`seqs`))
 * 
 * Three conditions need to be satisfied:
 *  1. the topological sort order exists
 *  2. the topological sort order is unique
 *  3. the topological sort order is equal to 'org'
 * 
 * References:
 *  https://leetcode.com/problems/sequence-reconstruction/discuss/92580/Java-Solution-using-BFS-Topological-Sort
 */
package com.zea7ot.leetcode.lvl3.lc0444;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0TopologicalSort {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        // sanity check
        if (org == null || org.length == 0 || seqs.isEmpty())
            return false;

        final int N = org.length;

        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, List<Integer>> graph = buildGraph(counts, seqs);
        if (counts.size() != N)
            return false;

        Deque<Integer> queue = new ArrayDeque<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet())
            if (entry.getValue() == 0)
                queue.offer(entry.getKey());

        int idx = 0;
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();
            if (SIZE > 1)
                return false;

            int cur = queue.poll();
            if (org[idx++] != cur)
                return false;

            if (graph.containsKey(cur)) {
                for (int next : graph.get(cur)) {
                    if (counts.put(next, counts.get(next) - 1) == 1)
                        queue.offer(next);

                    // equivalently
                    // counts.put(next, counts.get(next) - 1);
                    // if(counts.get(next) == 0)
                    // queue.offer(next);

                }
            }
        }

        return idx == N;
    }

    private Map<Integer, List<Integer>> buildGraph(Map<Integer, Integer> counts, List<List<Integer>> seqs) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (List<Integer> seq : seqs) {
            final int SIZE = seq.size();
            if (SIZE == 1) {
                int vertex = seq.get(0);
                graph.putIfAbsent(vertex, new ArrayList<>());
                counts.putIfAbsent(vertex, 0);
            } else
                for (int i = 1; i < SIZE; ++i) {
                    int prev = seq.get(i - 1), cur = seq.get(i);
                    graph.putIfAbsent(prev, new ArrayList<>());
                    graph.get(prev).add(cur);

                    counts.putIfAbsent(prev, 0);
                    counts.put(cur, counts.getOrDefault(cur, 0) + 1);
                }
        }

        return graph;
    }
}