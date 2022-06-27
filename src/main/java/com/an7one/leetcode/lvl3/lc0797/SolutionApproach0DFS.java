package com.an7one.leetcode.lvl3.lc0797;

import com.an7one.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/all-paths-from-source-to-target/">description</a>
 * <p>
 * Time Complexity:     O(V + E) ~ O(N + TOTAL_ELEMENTS)
 * Space Complexity:    O(V + E) ~ O(N + TOTAL_ELEMENTS)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFS {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        final List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (graph == null || graph.length == 0)
            return ans;

        // final int N = graph.length;
        backtrack(0, new ArrayList<>(), graph, ans);
        return ans;
    }

    private void backtrack(int cur, List<Integer> path, int[][] graph, List<List<Integer>> paths) {
        final int N = graph.length;
        path.add(cur);
        if (cur == N - 1)
            paths.add(new ArrayList<>(path));
        for (int next : graph[cur]) {
            backtrack(next, path, graph, paths);
        }
        path.remove(path.size() - 1);
    }
}