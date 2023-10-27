package com.idiotleon.leetcode.lvl3.lc0721;

import com.idiotleon.util.Constant;

import java.util.*;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/accounts-merge/">LC0721</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/accounts-merge/discuss/109157/JavaC++-Union-Find/241144">reference</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        final List<List<String>> ans = new ArrayList<>();
        // sanity check
        if (accounts == null || accounts.isEmpty()) {
            return ans;
        }

        final Map<String, Set<String>> graph = new HashMap<>();
        final Map<String, String> emailToName = new HashMap<>();

        /*
         * to build up the undirected graph
         *
         * e.g.:
         * {
         *  johnnybravo@mail.com=[],
         *  johnsmith@mail.com=[john00@mail.com, john_newyork@mail.com],
         *  john00@mail.com=[johnsmith@mail.com],
         *  john_newyork@mail.com=[johnsmith@mail.com],
         *  mary@mail.com=[]
         * }
         */
        for (final List<String> account : accounts) {
            final String name = account.get(0);
            final int SIZE = account.size();
            for (int i = 1; i < SIZE; ++i) {
                // required, especially in the situation where there is only one email after the name
                graph.putIfAbsent(account.get(i), new HashSet<>());
                emailToName.put(account.get(i), name);

                if (i > 1) {
                    graph.get(account.get(i)).add(account.get(i - 1));
                    graph.get(account.get(i - 1)).add(account.get(i));
                }
            }
        }

        // BFS
        final Set<String> visited = new HashSet<>();
        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                visited.add(email);
                final List<String> newList = bfs(graph, visited, email);
                Collections.sort(newList);
                newList.add(0, emailToName.get(newList.get(0)));
                ans.add(newList);
            }
        }

        return ans;
    }

    // the actual implementation of BFS (of an undirected graph)
    private List<String> bfs(final Map<String, Set<String>> graph, final Set<String> visited, final String startPos) {
        final List<String> newList = new ArrayList<>();
        final Deque<String> queue = new ArrayDeque<>();
        queue.addLast(startPos);

        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final String curEmail = queue.removeFirst();
                newList.add(curEmail);
                final Set<String> neighbors = graph.get(curEmail);
                for (final String neighbor : neighbors) {
                    if (visited.add(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return newList;
    }
}