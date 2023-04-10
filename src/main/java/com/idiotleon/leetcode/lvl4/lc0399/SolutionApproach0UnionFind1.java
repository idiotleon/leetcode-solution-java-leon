package com.idiotleon.leetcode.lvl4.lc0399;

import com.idiotleon.util.Constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/evaluate-division/">LC0399</a>
 * <p>
 * Time Complexity:     O(equations.size() + queries.size())
 * Space Complexity:    O(equations.size())
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/evaluate-division/discuss/278276/Java-Union-find-and-DFS">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0UnionFind1 {
    private final Map<String, String> roots = new HashMap<>();
    private final Map<String, Double> vals = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        final double[] ans = new double[queries.size()];

        for (int i = 0; i < values.length; ++i) {
            union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }

        for (int i = 0; i < queries.size(); i++) {
            final String x = queries.get(i).get(0), y = queries.get(i).get(1);
            ans[i] = (roots.containsKey(x) && roots.containsKey(y) && Objects.equals(find(x), find(y))) ? vals.get(x) / vals.get(y)
                    : -1.0;
        }

        return ans;
    }

    private void add(final String x) {
        if (roots.containsKey(x))
            return;
        roots.put(x, x);
        vals.put(x, 1.0);
    }

    private String find(String x) {
        final String root = roots.getOrDefault(x, x);
        if (!Objects.equals(x, root)) {
            final String grandRoot = find(root);
            vals.put(x, vals.get(x) * vals.get(root));
            roots.put(x, grandRoot);
        }
        return roots.getOrDefault(x, x);
    }

    private void union(String x, String y, double v) {
        add(x);
        add(y);
        String rootX = find(x), rootY = find(y);
        roots.put(rootX, rootY);
        vals.put(rootX, v * vals.get(y) / vals.get(x));
    }
}