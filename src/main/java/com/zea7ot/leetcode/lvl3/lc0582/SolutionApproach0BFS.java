/**
 * https://leetcode.com/problems/kill-process/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0582;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0BFS {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (pid == null || ppid == null || pid.isEmpty() || ppid.isEmpty() || pid.size() != ppid.size())
            return ans;

        final int N = pid.size();
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < N; ++i) {
            int parent = ppid.get(i), child = pid.get(i);
            graph.putIfAbsent(parent, new HashSet<Integer>());
            graph.get(parent).add(child);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(kill);

        while (!queue.isEmpty()) {
            int processId = queue.poll();
            ans.add(processId);

            if (graph.containsKey(processId)) {
                for (int process : graph.get(processId)) {
                    queue.add(process);
                }
            }
        }

        return ans;
    }
}