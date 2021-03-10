/**
 * https://leetcode.com/problems/find-eventual-safe-states/
 * 
 * Time Complexity:     O(V + E) ~ O(N + graph.length)
 * Space Complexity:    O(V + E) ~ O(N + graph.length)
 */
package com.an7one.leetcode.lvl3.lc0802;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0TopologicalSort1 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (graph == null || graph.length == 0)
            return ans;

        final int N = graph.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++)
            map.put(i, new HashSet<Integer>());

        int[] counts = new int[N];
        for (int parent = 0; parent < N; ++parent) {
            final int LEN = graph[parent].length;
            for (int j = 0; j < LEN; ++j) {
                int child = graph[parent][j];
                map.get(child).add(parent);

                ++counts[parent];
            }

            // equivalent
            // counts[parent] = graph[parent].length;
        }

        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < N; i++)
            if (counts[i] == 0)
                queue.add(i);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans.add(cur);

            for (int parent : map.get(cur))
                if (--counts[parent] == 0)
                    queue.add(parent);
        }

        Collections.sort(ans);

        return ans;
    }
}