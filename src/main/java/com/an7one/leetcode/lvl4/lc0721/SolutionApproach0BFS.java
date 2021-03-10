/**
 * https://leetcode.com/problems/accounts-merge/
 * 
 * Time Complexity:     O(V + E) + O() ~ 
 * Space Complexity:    O(V + E) + O() ~
 * 
 * References:
 *  https://leetcode.com/problems/accounts-merge/discuss/109157/JavaC++-Union-Find/241144
 */
package com.an7one.leetcode.lvl4.lc0721;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0BFS {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        // sanity check
        if (accounts == null || accounts.isEmpty())
            return ans;

        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        for (List<String> account : accounts) {
            final String NAME = account.get(0);
            final int SIZE = account.size();
            for (int i = 1; i < SIZE; ++i) {
                graph.putIfAbsent(account.get(i), new HashSet<>());
                emailToName.put(account.get(i), NAME);

                if (i > 1) {
                    String u = account.get(i - 1);
                    String v = account.get(i);
                    graph.get(u).add(v);
                    graph.get(v).add(u);
                }
            }
        }

        final Set<String> SEEN = new HashSet<>();
        for (String email : graph.keySet()) {
            if (!SEEN.add(email))
                continue;
            LinkedList<String> res = bfs(email, SEEN, graph);
            Collections.sort(res);
            res.addFirst(emailToName.get(res.get(0)));
            ans.add(res);
        }

        return ans;
    }

    private LinkedList<String> bfs(String start, final Set<String> SEEN, Map<String, Set<String>> graph) {
        LinkedList<String> res = new LinkedList<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                String cur = queue.poll();
                res.add(cur);
                for (String next : graph.get(cur)) {
                    if (!SEEN.add(next))
                        continue;
                    queue.offer(next);
                }
            }
        }

        return res;
    }
}
