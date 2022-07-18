package com.an7one.leetcode.lvl3.lc0582;

import com.an7one.util.Constant;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/kill-process/">LC0582</a>
 * <p>
 * Time Complexity:     O(V + E) ~ O(N)
 * Space Complexity:    O(V + E) ~ O(N)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        final List<Integer> ans = new ArrayList<>();
        // sanity check
        if (pid == null || ppid == null || pid.isEmpty() || ppid.isEmpty() || pid.size() != ppid.size())
            return ans;

        final int N = pid.size();
        final Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            int parent = ppid.get(i), child = pid.get(i);
            graph.putIfAbsent(parent, new HashSet<>());
            graph.get(parent).add(child);
        }

        final Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(kill);

        while (!queue.isEmpty()) {
            final int processId = queue.removeFirst();
            ans.add(processId);

            if (graph.containsKey(processId)) {
                for (final int process : graph.get(processId)) {
                    queue.addLast(process);
                }
            }
        }

        return ans;
    }
}