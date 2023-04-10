package com.idiotleon.leetcode.lvl3.lc0802;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/find-eventual-safe-states/">description</a>
 * <p>
 * Time Complexity:     O(V + E) ~ O(`N` + numEdges)
 * Space Complexity:    O(V + E) ~ O(`N` + numEdges)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0KahnsAlgorithm1 {
    public List<Integer> eventualSafeNodes(final int[][] graph) {
        final List<Integer> ans = new ArrayList<>();
        // sanity check
        if (graph == null || graph.length == 0)
            return ans;

        final int N = graph.length;
        final Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            map.put(i, new HashSet<>());
        }

        final int[] indegrees = new int[N];
        for (int parent = 0; parent < N; ++parent) {
            final int LEN = graph[parent].length;
            for (int j = 0; j < LEN; ++j) {
                int child = graph[parent][j];
                map.get(child).add(parent);

                ++indegrees[parent];
            }

            // equivalent
            // indegrees[parent] = graph[parent].length;
        }

        final Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (indegrees[i] == 0)
                queue.addLast(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.removeFirst();
            ans.add(cur);

            for (int parent : map.get(cur)) {
                if (--indegrees[parent] == 0)
                    queue.addLast(parent);
            }
        }

        Collections.sort(ans);

        return ans;
    }
}