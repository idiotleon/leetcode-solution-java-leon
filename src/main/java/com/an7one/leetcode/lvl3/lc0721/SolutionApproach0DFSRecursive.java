package com.an7one.leetcode.lvl3.lc0721;

import com.an7one.util.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/accounts-merge/">LC0721</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/accounts-merge/discuss/109157/JavaC++-Union-Find/241144">reference</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DFSRecursive {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        final List<List<String>> ans = new ArrayList<>();
        // sanity check
        if (accounts == null || accounts.isEmpty()) return ans;

        final Map<String, Set<String>> graph = new HashMap<>();
        final Map<String, String> emailToName = new HashMap<>();

        // to build up the undirected graph,
        // as well the as the owner table/map
        for (final List<String> account : accounts) {
            final String name = account.get(0);
            final int SIZE = account.size();
            for (int i = 1; i < SIZE; ++i) {
                graph.putIfAbsent(account.get(i), new HashSet<>());
                emailToName.put(account.get(i), name);

                if (i != 1) {
                    graph.get(account.get(i)).add(account.get(i - 1));
                    graph.get(account.get(i - 1)).add(account.get(i));
                }
            }
        }

        // DFS
        final Set<String> visited = new HashSet<>();
        for (String email : graph.keySet()) {
            if (visited.add(email)) {
                final List<String> newList = new ArrayList<>();
                dfs(graph, newList, visited, email);
                Collections.sort(newList);
                newList.add(0, emailToName.get(newList.get(0)));
                ans.add(newList);
            }
        }

        return ans;
    }

    // the actual implementation of DFS
    private void dfs(final Map<String, Set<String>> graph, final List<String> result, final Set<String> visited, final String curPoint) {
        result.add(curPoint);
        final Set<String> neighbors = graph.get(curPoint);
        for (String neighbor : neighbors) {
            if (visited.add(neighbor))
                dfs(graph, result, visited, neighbor);
        }
    }
}