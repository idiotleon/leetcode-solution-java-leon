/**
 * https://leetcode.com/problems/accounts-merge/
 * 
 * Time Complexity:     O(V + E) ~ O()
 * Space Complexity:    O(V + E)
 * 
 * References:
 *  https://leetcode.com/problems/accounts-merge/discuss/109158/Java-Solution-(Build-graph-+-DFS-search)/111225
 *  https://leetcode.com/problems/accounts-merge/discuss/109158/Java-Solution-(Build-graph-%2B-DFS-search)
 */
package com.an7one.leetcode.lvl4.lc0721;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0DFSRecursive {
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
            LinkedList<String> res = new LinkedList<>();
            dfs(email, SEEN, res, graph);
            Collections.sort(res);
            res.addFirst(emailToName.get(res.get(0)));
            ans.add(res);
        }

        return ans;
    }

    private void dfs(String cur, final Set<String> SEEN, LinkedList<String> res, Map<String, Set<String>> graph) {
        // this line is illegit because ofline 40
        // if(!SEEN.add(cur)) return;
        res.add(cur);
        for (String next : graph.get(cur)) {
            if (!SEEN.add(next))
                continue;
            dfs(next, SEEN, res, graph);
        }
    }
}
