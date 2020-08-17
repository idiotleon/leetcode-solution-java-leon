/**
 * https://leetcode.com/problems/bus-routes/
 * 
 * Time Complexity:     O(V + E) ~ O(routes.length + TOTAL_LEN(routes))
 * Space Complexity:    O(V + E) ~ O(routes.length + TOTAL_LEN(routes))
 */
package com.zea7ot.leetcode.lvl4.lc0815;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0BFS {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        // sanity check
        if (routes == null || routes.length == 0 || routes[0].length == 0)
            return 0;

        Map<Integer, Set<Integer>> graph = buildGraph(routes);

        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(S);

        Set<Integer> seen = new HashSet<Integer>();
        seen.add(S);

        int count = 0;
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                int stop = queue.pop();
                if (stop == T)
                    return count;

                if (!graph.containsKey(stop))
                    continue;

                Set<Integer> buses = graph.get(stop);
                for (int bus : buses) {
                    for (int next : routes[bus]) {
                        if (!seen.add(next))
                            continue;
                        queue.add(next);
                        graph.get(next).remove(bus);
                    }
                }

                graph.remove(stop);
            }

            ++count;
        }

        return -1;
    }

    private Map<Integer, Set<Integer>> buildGraph(int[][] routes) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        final int N = routes.length;
        for (int i = 0; i < N; ++i) {
            for (int stop : routes[i]) {
                graph.putIfAbsent(stop, new HashSet<Integer>());
                graph.get(stop).add(i);
            }
        }
        return graph;
    }
}