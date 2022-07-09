package com.an7one.leetcode.lvl4.lc0399;

import com.an7one.util.Constant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/evaluate-division/">LC0309</a>
 * <p>
 * Time Complexity:
 * O(queries.size() * (equations.size() + 2 * values.length)) + O(equations.size()) ~ O(queries.size() * (equations.size() + 2 * values.length))
 * O(equations.size()), to build up the graph
 * O(queries.size() * (equations.size() + 2 * values.length)), to DFS the graph
 * <p>
 * Space Complexity:
 * O(2 * (equations.size() + values.length)) + O(values.length) ~ O(2 * (equations.size() + values.length))
 * O(2 * (equations.size() + values.length)), to build up the graph
 * O(values.length), for the visited set
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/evaluate-division/discuss/88169/Java-AC-Solution-using-graph/126499">LC Discussion</a>
 * <a href="https://leetcode.com/problems/evaluate-division/discuss/171649/1ms-DFS-with-Explanations">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        final int SIZE = queries.size();
        final Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        final double[] ans = new double[SIZE];

        for (int i = 0; i < SIZE; ++i) {
            ans[i] = getPathWeight(graph, new HashSet<>(), queries.get(i).get(0), queries.get(i).get(1));
        }

        return ans;
    }

    private double getPathWeight(final Map<String, Map<String, Double>> graph, final Set<String> visited, final String start,
                                 final String end) {

        if (!graph.containsKey(start))
            return -1.0;

        if (graph.get(start).containsKey(end))
            return graph.get(start).get(end);

        visited.add(start);
        for (final Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                final double productWeight = getPathWeight(graph, visited, neighbor.getKey(), end);
                if (productWeight != -1.0) {
                    return neighbor.getValue() * productWeight;
                }
            }
        }

        return -1.0;
    }

    private Map<String, Map<String, Double>> buildGraph(final List<List<String>> equations, final double[] values) {
        final int SIZE = equations.size();
        final Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < SIZE; i++) {
            final String u = equations.get(i).get(0);
            final String v = equations.get(i).get(1);
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1 / values[i]);
        }

        return graph;
    }
}