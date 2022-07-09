package com.an7one.leetcode.lvl4.lc0399;

import com.an7one.util.Constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/evaluate-division/">LC0399</a>
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0UnionFind {
    public double[] calcEquation(final List<List<String>> equations, final double[] values, final List<List<String>> queries) {
        final Map<String, String> roots = new HashMap<>();
        final Map<String, Double> ratios = new HashMap<>();

        for (int i = 0; i < equations.size(); ++i) {
            union(equations.get(i).get(0), equations.get(i).get(1), values[i], roots, ratios);
        }

        final double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); ++i) {
            final String start = queries.get(i).get(0), end = queries.get(i).get(1);
            if (!roots.containsKey(start) || !roots.containsKey(end)
                    || !Objects.equals(find(start, roots, ratios), find(end, roots, ratios))) {
                ans[i] = -1.0;
            } else {
                ans[i] = ratios.get(start) / ratios.get(end);
            }
        }

        return ans;
    }

    private void union(
            final String start,
            final String end,
            final double val,
            final Map<String, String> roots,
            final Map<String, Double> ratios) {
        roots.putIfAbsent(start, start);
        ratios.putIfAbsent(start, 1.0);

        roots.putIfAbsent(end, end);
        ratios.putIfAbsent(end, 1.0);

        final String rootStart = find(start, roots, ratios);
        final String rootEnd = find(end, roots, ratios);
        roots.put(rootStart, rootEnd);
        ratios.put(rootStart, val * ratios.get(end) / ratios.get(start));
    }

    private String find(final String start, final Map<String, String> roots, final Map<String, Double> ratios) {
        if (start.equals(roots.get(start)))
            return start;

        final String father = roots.get(start);
        final String grandpa = find(father, roots, ratios);
        roots.put(start, grandpa); // path compression
        ratios.put(start, ratios.get(start) * ratios.get(father));
        return grandpa;
    }
}